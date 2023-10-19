package com.resourciumoptima;

import java.io.*;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.repository.EmployeeRepository;
import com.resourciumoptima.utils.HibernateUtil;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private EntityManagerFactory em;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        em = HibernateUtil.getEntityManagerFactory();

        if (request.getSession().getAttribute("employee") == null) {
            response.sendRedirect(request.getContextPath() + "/loginPage");
        } else {
            try {
                EmployeeRepository employeeRepository = new EmployeeRepository(em.createEntityManager());
                Employee employee = employeeRepository.findById((Long) request.getSession().getAttribute("employee"));
                if (employee != null) {
                    request.setAttribute("employee", employee);
                    request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/dashboard");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void destroy() {
    }
}