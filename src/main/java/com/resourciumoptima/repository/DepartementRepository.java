package com.resourciumoptima.repository;

import java.util.List;
import com.resourciumoptima.domain.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class DepartementRepository {
//    Department findById(Long id);
//    List<Department> findAll();
//    void save(Department department);
//    void update(Department department);
//    void delete(Department department);


    @PersistenceContext
       private EntityManager em;

       public Department findById(Long id) {
           return em.find(Department.class, id);
       }

       // JPQL (Java Persistence Query Language)
         public List<Department> findAll() {
              return em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
         }

        public void save(Department department) {
             em.persist(department);
         }
         public void update(Department department) {
             em.merge(department);
         }
         public void delete(Department department) {
           em.remove(department);
       }




}
