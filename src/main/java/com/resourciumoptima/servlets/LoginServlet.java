package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.repository.EmployeeRepository;
import com.resourciumoptima.utils.EntityManagerUtil;
import com.resourciumoptima.utils.ValidationUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/loginPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String hashedPassword = ValidationUtils.hashPassword(password);

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            EmployeeRepository employeeRepository = new EmployeeRepository(em);
            List<Employee> employees = employeeRepository.findAll();

            for (Employee employee : employees) {
                if (employee.getUsername().equals(username) && employee.getPassword().equals(hashedPassword)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("id", employee.getId());
                    session.setAttribute("firstName", employee.getFirstName());
                    session.setAttribute("lastName", employee.getLastName());
                    session.setAttribute("email", employee.getEmail());

                    System.out.println("User " + username + " logged in");

                    response.sendRedirect(request.getContextPath() + "/dashboard");
                    return;
                }
            }

            request.setAttribute("error", "Invalid username or password");
            System.out.println();
            request.getRequestDispatcher("/WEB-INF/jsp/loginPage.jsp").forward(request, response);
        } finally {
            EntityManagerUtil.closeEntityManager();
        }
    }
}
