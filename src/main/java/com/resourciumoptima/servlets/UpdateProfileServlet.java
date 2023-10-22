package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.repository.EmployeeRepository;
import com.resourciumoptima.service.EmployeeService;
import com.resourciumoptima.utils.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EmployeeService employeeService = new EmployeeService(new EmployeeRepository(entityManager));

        int employeeId = (int) request.getSession().getAttribute("id");
        Employee employee = employeeService.getEmployeeById(employeeId);

        entityManager.close();

        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/updateProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EmployeeService employeeService = new EmployeeService(new EmployeeRepository(entityManager));

        int employeeId = (int) request.getSession().getAttribute("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Employee employee = employeeService.getEmployeeById(employeeId);

        employee.setUsername(username);
        employee.setPassword(password);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);

        employeeService.updateEmployee(employee);

        entityManager.close();

        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
