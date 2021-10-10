package spring.webapp.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.webapp.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
