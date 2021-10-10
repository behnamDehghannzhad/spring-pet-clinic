package spring.webapp.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.webapp.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
