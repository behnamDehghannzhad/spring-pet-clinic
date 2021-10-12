package spring.webapp.petclinic.servies.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.webapp.petclinic.model.Owner;
import spring.webapp.petclinic.model.Pet;
import spring.webapp.petclinic.model.PetType;
import spring.webapp.petclinic.servies.OwnerService;
import spring.webapp.petclinic.servies.PetService;
import spring.webapp.petclinic.servies.PetTypeService;

import java.util.Objects;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (Objects.nonNull(owner)) {
            saveOwnerPets(owner.getPets());
            return super.save(owner);
        } else {
            return null;
        }
    }

    private void saveOwnerPets(Set<Pet> pets) {
        if (Objects.nonNull(pets)) {
            pets.forEach(pet -> {
                if (Objects.nonNull(pet.getPetType()) && Objects.nonNull(pet.getPetType().getId())) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                } else {
                    throw new RuntimeException("Pet Type is Required");
                }

                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            });
        }
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return findAll().stream()
                .filter(owner -> Objects.equals(owner.getLastName(), lastName))
                .findFirst()
                .orElse(null);
    }
}
