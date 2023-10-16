package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Equipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class EquipementRepository {
    @PersistenceContext
    private EntityManager em;

    Equipment findById(Long id) {
        return em.find(Equipment.class, id);
    }
    List<Equipment> findAll() {
        return em.createQuery("SELECT e FROM Equipment e", Equipment.class).getResultList();
    }
    void save(Equipment equipment) {
        em.persist(equipment);
    }
    void update(Equipment equipment) {
        em.merge(equipment);
    }
    void delete(Equipment equipment) {
        em.remove(equipment);
    }
}
