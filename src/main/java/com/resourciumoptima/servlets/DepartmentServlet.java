//package com.resourciumoptima.servlets;
//
//import com.resourciumoptima.domain.Department;
//import com.resourciumoptima.repository.DepartmentRepository;
//import com.resourciumoptima.service.DepartmentService;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/departments")
//public class DepartmentServlet extends HttpServlet {
//    private DepartmentService departmentService;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        departmentService = new DepartmentService(new DepartmentRepository();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action != null) {
//            if (action.equals("delete")) {
//                deleteDepartment(request, response);
//            }
//        } else {
//            List<Department> departments = departmentService.
//            request.setAttribute("departments", departments);
//            request.getRequestDispatcher("departments.jsp").forward(request, response);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action != null) {
//            if (action.equals("create")) {
//                createDepartment(request, response);
//            } else if (action.equals("update")) {
//                updateDepartment(request, response);
//            }
//        }
//    }
//
//    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
//
//
//
//
