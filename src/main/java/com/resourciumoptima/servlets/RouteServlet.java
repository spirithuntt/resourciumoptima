package com.resourciumoptima.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RouteServlet", value = {"/login", "/registration", "/dashboard", "/profile"})
public class RouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();

        System.out.println(path);

        switch (path) {
            case "/login":
                RequestDispatcher loginDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                loginDispatcher.forward(request, response);
                break;
            case "/registration":
                RequestDispatcher registrationDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
                registrationDispatcher.forward(request, response);
                break;
            case "/dashboard":
                RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp");
                dashboardDispatcher.forward(request, response);
                break;
            case "/profile":
                RequestDispatcher profileDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
                profileDispatcher.forward(request, response);
                break;
            default:
                response.sendRedirect("/errorPage");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
