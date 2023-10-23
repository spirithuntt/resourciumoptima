package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Employee;

import jakarta.persistence.*;

import java.util.List;

public class EmployeeRepository {
    private final EntityManager em;

    public EmployeeRepository(EntityManager em) {
        this.em = em;
    }

    public Employee save(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        return employee;
    }

    public void update(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
        em.getTransaction().commit();
    }

    public Employee findById(long id) {
        return em.find(Employee.class, id);
    }
    public List<Employee> findAll() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }
    public boolean isEmailTaken(String email) {
        String jpql = "SELECT COUNT(e) FROM Employee e WHERE e.email = :email";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("email", email);
        return query.getSingleResult() > 0;
    }
}
