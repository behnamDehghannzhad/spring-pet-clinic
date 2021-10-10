package spring.webapp.petclinic.servies.springDataService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.webapp.petclinic.model.Speciality;
import spring.webapp.petclinic.repository.SpecialityRepository;
import spring.webapp.petclinic.servies.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class SpecialitySDJpaService implements SpecialtyService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
