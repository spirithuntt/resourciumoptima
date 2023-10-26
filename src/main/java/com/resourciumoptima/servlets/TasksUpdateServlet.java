package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Task;
import com.resourciumoptima.domain.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "TasksUpdateServlet", value = "/TasksUpdateServlet")
public class TasksUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//
//        System.out.println(description);
//        System.out.println(deadline);
//        System.out.println(priority);
//        System.out.println(status);
//        System.out.println(assignedEmployeeId);
        int taskId = Integer.parseInt(request.getParameter("taskIdUpdate"));  // Get the task ID
        int assignedUserIdUpdate = Integer.parseInt(request.getParameter("assignedToUpdate"));
        String descriptionUpdate = request.getParameter("descriptionUpdate");
        String priorityUpdate = request.getParameter("priorityUpdate");
        String statusUpdate = request.getParameter("statusUpdate");
        String deadlineUpdate = request.getParameter("deadlineUpdate");


        System.out.println(taskId);
        System.out.println(assignedUserIdUpdate);
        System.out.println(descriptionUpdate);
        System.out.println(priorityUpdate);
        System.out.println(statusUpdate);
        System.out.println(deadlineUpdate);

        LocalDate deadline = parseDate(deadlineUpdate);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Task task = entityManager.find(Task.class, taskId);

            if (task != null) {
                task.setDescription(descriptionUpdate);
                task.setPriority(priorityUpdate);
                task.setStatus(statusUpdate);
                task.setDeadline(deadlineUpdate);


Employee assignedEmployee = entityManager.find(Employee.class, assignedUserIdUpdate);
                task.setAssignedEmployee(assignedEmployee);

                entityManager.merge(task);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

//        response.sendRedirect(request.getContextPath() + "/tasks");

    }

    private LocalDate parseDate(String dateString) {
        if (dateString != null && !dateString.isEmpty()) {
            return LocalDate.parse(dateString);
        }
        return null;
    }

}