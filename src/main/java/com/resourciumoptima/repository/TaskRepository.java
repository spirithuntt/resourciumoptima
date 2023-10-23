package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Task;

import jakarta.persistence.*;

import java.util.List;

public class TaskRepository {
    private final EntityManager em;

    public TaskRepository(EntityManager em) {
        this.em = em;
    }

    public Task save(Task task) {
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
        return task;
    }

    public void update(Task task) {
        em.getTransaction().begin();
        em.merge(task);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        em.getTransaction().begin();
        Task task = em.find(Task.class, id);
        em.remove(task);
        em.getTransaction().commit();
    }

    public Task findById(int id) {
        return em.find(Task.class, id);
    }

    public List<Task> findAll() {
        return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }
}
