package spring.webapp.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.webapp.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
