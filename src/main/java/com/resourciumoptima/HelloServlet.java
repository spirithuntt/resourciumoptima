package com.resourciumoptima;

import jakarta.persistence.EntityManager;
import java.io.*;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "HelloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private String message;

    private EntityManagerFactory emf;

    public void init() {
        message = "Hello World!";

        // Create the EntityManagerFactory using the
        // persistence-unit name from persistence.xml
        emf = Persistence.createEntityManagerFactory("com.resourciumoptima");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Your application logic here

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        // Close the EntityManagerFactory when the servlet is destroyed
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
