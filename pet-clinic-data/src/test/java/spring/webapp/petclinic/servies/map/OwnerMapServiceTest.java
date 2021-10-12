package spring.webapp.petclinic.servies.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.webapp.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Long ownerId = 1L;
    String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        assertEquals(ownerMapService.findAll().size(), 1);
    }

    @Test
    void findById() {
        assertEquals(ownerMapService.findById(ownerId).getId(), 1L);
    }

    @Test
    void save() {
        Long id = 4L;
        Owner savedOwner = ownerMapService.save(Owner.builder().id(id).build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
        assertEquals(savedOwner.getId(), id);
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(ownerMapService.findAll().size(), 0);
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerMapService.findById(ownerId).getId());
        assertEquals(ownerMapService.findAll().size(), 0);
    }

    @Test
    void findByLastName() {
        assertEquals(ownerMapService.findByLastName(lastName).getLastName(), lastName);
    }

    @Test
    void findByLastNameNotFound() {
        assertNull(ownerMapService.findByLastName("koo"));
    }
}