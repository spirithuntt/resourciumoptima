package com.resourciumoptima.servlets;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.repository.EmployeeRepository;
import com.resourciumoptima.utils.ValidationUtils;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    final EntityManager em = com.resourciumoptima.utils.EntityManagerUtil.getEntityManager();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String position = request.getParameter("position");

        if (username == null || username.isEmpty() || password1 == null || password1.isEmpty() || password2 == null || password2.isEmpty() || email == null || email.isEmpty() || !password1.equals(password2)) {
            //debbug
            System.out.println("Invalid data");
            System.out.println("username: " + username);
            System.out.println("password1: " + password1);
            System.out.println("password2: " + password2);
            System.out.println("firstname: " + firstname);
            System.out.println("lastname: " + lastname);
            System.out.println("email: " + email);
            System.out.println("password.equals(password2): " + password1.equals(password2));
            response.sendRedirect("register.jsp?error=invalid");
            return;
        }

        String hashedPassword = ValidationUtils.hashPassword(password1);

        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setFirstName(firstname);
        employee.setLastName(lastname);
        employee.setPassword(hashedPassword);
        employee.setEmail(email);
        employee.setPosition(position);
        Date date = new Date();
        String hiringDate = date.toString();
        employee.setHiringDate(hiringDate);

        EmployeeRepository employeeRepository = new EmployeeRepository(em);
        employeeRepository.save(employee);

        System.out.println("Employee saved");

        response.sendRedirect(request.getContextPath() + "/login");
    }
}
