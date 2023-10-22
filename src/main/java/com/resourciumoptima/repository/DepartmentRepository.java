package com.resourciumoptima.repository;

import java.util.List;
import com.resourciumoptima.domain.Department;
import jakarta.persistence.EntityManager;

public class DepartmentRepository {

    private final EntityManager em;

    public DepartmentRepository(EntityManager em) {
        this.em = em;
    }

    public Department save(Department department) {
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        return department;
    }
    public void update(Department department) {
        em.getTransaction().begin();
        em.merge(department);
        em.getTransaction().commit();
    }
    public void delete(long id) {
        em.getTransaction().begin();
        Department department = em.find(Department.class, id);
        em.remove(department);
        em.getTransaction().commit();
    }

    public Department findById(long id) {
        return em.find(Department.class, id);
    }
    public List<Department> findAll() {
        return em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
    }

}
