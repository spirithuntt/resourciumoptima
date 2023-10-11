package com.resourciumoptima.repository;


import com.resourciumoptima.domain.Employee;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;


public class EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    public void delete(Employee employee) {
        entityManager.remove(employee);
    }



}
