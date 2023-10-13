package com.resourciumoptima;

import java.io.*;

import com.resourciumoptima.repository.EmployeeRepository;
import com.resourciumoptima.utils.HibernateUtil;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private EntityManagerFactory sessionFactory;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sessionFactory = HibernateUtil.getEntityManagerFactory();
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Session factory is created in init: " + sessionFactory);
    }

    public void destroy() {
    }
}