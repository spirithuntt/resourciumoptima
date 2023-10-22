package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.utils.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmailAddress = (String) request.getSession().getAttribute("email");

        if (userEmailAddress != null) {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            Employee employee = null;

            try {
                entityManager.getTransaction().begin();

                // Retrieve the user information based on the email address
                employee = entityManager.createQuery("SELECT u FROM Employee u WHERE u.email = :email", Employee.class)
                        .setParameter("email", userEmailAddress)
                        .getSingleResult();

                entityManager.getTransaction().commit();
            } catch (Exception e) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                e.printStackTrace();
            } finally {
                EntityManagerUtil.closeEntityManager();
            }

            if (employee != null) {
                // Set user information as session attributes
                HttpSession session = request.getSession();
                session.setAttribute("username", employee.getUsername());
                session.setAttribute("firstName", employee.getFirstName());
                session.setAttribute("lastName", employee.getLastName());
                session.setAttribute("email", employee.getEmail());
            }
        }

        // Forward the request to the profile JSP
        request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String email = request.getParameter("email");

        String userEmailAddress = (String) request.getSession().getAttribute("email");

        if (userEmailAddress != null) {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            EntityTransaction transaction = null;

            try {
                transaction = entityManager.getTransaction();
                transaction.begin();

                Employee employee = entityManager.createQuery("SELECT u FROM Employee u WHERE u.email = :email", Employee.class)
                        .setParameter("email", userEmailAddress)
                        .getSingleResult();

                employee.setUsername(username);
                employee.setFirstName(firstname);
                employee.setLastName(lastname);
                employee.setEmail(email);

                transaction.commit();

                // Update session attributes
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("firstName", firstname);
                session.setAttribute("lastName", lastname);
                session.setAttribute("email", email);

                System.out.println("Employee updated");

                response.sendRedirect(request.getContextPath() + "/profile");
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/profile?error=1");
            } finally {
                EntityManagerUtil.closeEntityManager();
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/profile?error=1");
        }
    }
}
