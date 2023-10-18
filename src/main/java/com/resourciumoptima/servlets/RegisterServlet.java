package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String name = req.getParameter("name");
        String firstname = req.getParameter("firstname");
        String email = req.getParameter("email");
        String position = req.getParameter("position");
        String hiringDate = req.getParameter("hiringDate");
        String department = req.getParameter("department");

        if (username == null || username.isEmpty() || password1 == null || password1.isEmpty() || password2 == null || password2.isEmpty() || name == null || name.isEmpty() || firstname == null || firstname.isEmpty() || email == null || email.isEmpty() || position == null || position.isEmpty() || hiringDate == null || hiringDate.isEmpty() || department == null || department.isEmpty()) {
            req.setAttribute("error", "please fill all the fields");
            req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
        } else if (!password1.equals(password2)) {
            req.setAttribute("error", "passwords are not the same");
            req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
        } else {
            long userCount = entityManager.createQuery("SELECT COUNT(e) FROM Employee e WHERE e.username = :username", Long.class)
                    .setParameter("username", username)
                    .getSingleResult();

            if (userCount > 0) {
                req.setAttribute("error", "Username already exists");
                req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
            } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    hiringDate = dateFormat.format(hiringDate);

                    Employee newUser = new Employee(username, password1, name, firstname, email, position, hiringDate);

                    // TODO: Set the department for the user (i need to obtain the department entity)

                    entityManager.persist(newUser);

                    req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            }
        }
    }
}
