package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Equipement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class EquipementRepository {
    private final EntityManager em;

    public EquipementRepository(EntityManager em) {
        this.em = em;
    }

    public Equipement save(Equipement equipement) {
        em.getTransaction().begin();
        em.persist(equipement);
        em.getTransaction().commit();
        return equipement;
    }

    public void update(Equipement equipement) {
        em.getTransaction().begin();
        em.merge(equipement);
        em.getTransaction().commit();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        Equipement equipement = em.find(Equipement.class, id);
        em.remove(equipement);
        em.getTransaction().commit();
    }

    public Equipement findById(long id) {
        return em.find(Equipement.class, id);
    }


}
