package com.resourciumoptima;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello World!";

        // Create the EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");

        // Store the EntityManagerFactory in the servlet context
        ServletContext context = getServletContext();
        context.setAttribute("entityManagerFactory", emf);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Your application logic here, including creating EntityManagers

        // Close EntityManagers when done

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        // Retrieve and close the EntityManagerFactory
        ServletContext context = getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("entityManagerFactory");
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
