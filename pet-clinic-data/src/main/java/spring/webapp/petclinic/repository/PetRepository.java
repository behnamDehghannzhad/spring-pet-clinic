package spring.webapp.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.webapp.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
