package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }
    public Role findByName(String name) {
        return entityManager.find(Role.class, name);
    }
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }
    public void save(Role role) {
        entityManager.persist(role);
    }
    public void update(Role role) {
        entityManager.merge(role);
    }
    public void delete(Role role) {
        entityManager.remove(role);
    }

}
