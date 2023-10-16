package com.resourciumoptima.repository;

import com.resourciumoptima.domain.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class EmployeeRepository {
    @PersistenceContext
    private EntityManager em;

    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }
    public List<Employee> findAll() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public void save(Employee employee) {
        em.persist(employee);
    }

    public void update(Employee employee) {
        em.merge(employee);
    }

    public void delete(Employee employee) {
        em.remove(em.contains(employee) ? employee : em.merge(employee));
    }
}
