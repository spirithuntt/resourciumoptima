package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Equipement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class EquipementRepository {
    @PersistenceContext
    private EntityManager em;

    Equipement findById(Long id) {
        return em.find(Equipement.class, id);
    }
    List<Equipement> findAll() {
        return em.createQuery("SELECT e FROM Equipement e", Equipement.class).getResultList();
    }
    void save(Equipement equipement) {
        em.persist(equipement);
    }
    void update(Equipement equipement) {
        em.merge(equipement);
    }
    void delete(Equipement equipement) {
        em.remove(equipement);
    }
}
