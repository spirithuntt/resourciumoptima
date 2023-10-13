package com.resourciumoptima.repository;


import com.resourciumoptima.domain.Employee;

import jakarta.persistence.*;


public class EmployeeRepository {
    final private EntityManagerFactory emf;

    public EmployeeRepository() {
        this.emf = Persistence.createEntityManagerFactory("com.resourciumoptima");
    }

    public void save(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }

//    public Employee findById(int id) {
//        return emf.find(Employee.class, id);
//    }
//
//    public void update(Employee employee) {
//        emf.merge(employee);
//    }
//
//    public void delete(Employee employee) {
//        emf.remove(employee);
//    }


}
