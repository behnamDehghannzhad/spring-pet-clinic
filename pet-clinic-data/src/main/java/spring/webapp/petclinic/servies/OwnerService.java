package spring.webapp.petclinic.servies;

import spring.webapp.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
