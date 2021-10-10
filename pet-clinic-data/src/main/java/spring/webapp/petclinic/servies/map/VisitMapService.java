package spring.webapp.petclinic.servies.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.webapp.petclinic.model.Visit;
import spring.webapp.petclinic.servies.VisitService;

import java.util.Objects;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService  extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        boolean isInValidPet = Objects.isNull(visit.getPet()) || Objects.isNull(visit.getPet().getId());
        boolean isInValidOwner = Objects.isNull(visit.getPet().getOwner()) || Objects.isNull(visit.getPet().getOwner().getId());
        if(isInValidPet || isInValidOwner)
            throw new RuntimeException("invalid visit");

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
