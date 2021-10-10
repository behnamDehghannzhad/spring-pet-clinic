package spring.webapp.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.webapp.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
