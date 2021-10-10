package spring.webapp.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.webapp.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
