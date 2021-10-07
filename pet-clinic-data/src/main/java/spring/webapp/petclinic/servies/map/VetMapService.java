package spring.webapp.petclinic.servies.map;

import org.springframework.stereotype.Service;
import spring.webapp.petclinic.model.Speciality;
import spring.webapp.petclinic.model.Vet;
import spring.webapp.petclinic.servies.SpecialtyService;
import spring.webapp.petclinic.servies.VetService;

import java.util.Objects;
import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet>findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        saveVetSpeciality(vet.getSpecialities());
        return super.save(vet);
    }

    private void saveVetSpeciality(Set<Speciality> specialities) {
        specialities.forEach(speciality -> {
            if (Objects.nonNull(speciality.getId())) {
                Speciality savedSpeciality = specialtyService.save(speciality);
                savedSpeciality.setId(savedSpeciality.getId());
            }
        });
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
