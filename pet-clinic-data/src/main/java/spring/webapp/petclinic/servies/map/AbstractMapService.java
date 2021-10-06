package spring.webapp.petclinic.servies.map;

import spring.webapp.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (Objects.nonNull(object)) {
            if (Objects.isNull(object.getId())) {
                map.put(getNextId(), object);
            }
        } else {
            throw new RuntimeException("object cannot be null");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> Objects.equals(entry.getValue(), object));
    }

    private Long getNextId() {
        Long nextId;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
