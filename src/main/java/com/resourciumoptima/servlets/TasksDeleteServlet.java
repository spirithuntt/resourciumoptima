package com.resourciumoptima.servlets;


import com.resourciumoptima.domain.Task;
import com.resourciumoptima.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TasksDeleteServlet", value = "/TasksDeleteServlet")
public class TasksDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deletee!!!!!!!");
        int taskId = Integer.parseInt(request.getParameter("taskId"));

        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        try {
            Task taskToDelete = em.find(Task.class, taskId);

            if (taskToDelete != null) {
                EntityTransaction transaction = em.getTransaction();

                try {
                    transaction.begin();
                    em.remove(taskToDelete);
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null && transaction.isActive()) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                }
            }
        } finally {
            em.close();
            emf.close();
        }

//        response.sendRedirect(request.getContextPath() + "/tasks");
    }

}