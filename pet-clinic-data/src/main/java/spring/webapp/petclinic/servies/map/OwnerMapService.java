package spring.webapp.petclinic.servies.map;

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
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner>findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (Objects.nonNull(owner)) {
            Set<Pet> pets = saveOwnerPets(owner.getPets());
            owner.setPets(pets);
            return super.save(owner);
        } else {
            return null;
        }
    }

    private Set<Pet> saveOwnerPets(Set<Pet> pets) {
        pets.forEach(pet -> {
            if (Objects.nonNull(pet.getPetType())) {
                pet.setPetType(petTypeService.save(pet.getPetType()));
            } else {
                throw new RuntimeException("Pet Type is Required");
            }

            Pet savedPet = petService.save(pet);
            pet.setId(savedPet.getId());
        });
        return pets;
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
        return null;
    }
}
