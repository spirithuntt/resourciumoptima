package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class TaskRepository {
    @PersistenceContext
    private EntityManager em;

    Task findById(Long id) {
        return em.find(Task.class, id);
    }

    List<Task> findAll() {
        return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }
    void save(Task task) {
        em.persist(task);
    }
    void update(Task task) {
        em.merge(task);
    }
    void delete(Task task) {
        em.remove(task);
    }
}
