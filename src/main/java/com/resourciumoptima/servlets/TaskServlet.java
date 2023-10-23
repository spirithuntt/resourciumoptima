package com.resourciumoptima.servlets;


import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.domain.Task;
import com.resourciumoptima.repository.EmployeeRepository;
import com.resourciumoptima.repository.TaskRepository;
import com.resourciumoptima.service.EmployeeService;
import com.resourciumoptima.service.TaskService;
import com.resourciumoptima.utils.EntityManagerUtil;
import jakarta.persistence.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
@WebServlet(name = "TaskServlet", value = "/tasks")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testttt");
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        TaskService taskService = new TaskService(new TaskRepository(entityManager));
        EmployeeService employeeService = new EmployeeService(new EmployeeRepository(entityManager));

        try {
            List<Task> tasks = taskService.getAllTasks();

            List<Employee> employees = employeeService.getAllEmployees();


            request.setAttribute("tasks", tasks);
            request.setAttribute("employees", employees);



            System.out.println(tasks);
            System.out.println(employees);

            request.getRequestDispatcher("/WEB-INF/jsp/addTask.jsp").forward(request, response);

        } finally {
            EntityManagerUtil.closeEntityManager();
        }

        System.out.println("testttt");

        request.getRequestDispatcher("/WEB-INF/jsp/addTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doPost");
        String description = request.getParameter("description");
        String deadline = request.getParameter("deadline");
        String priority = request.getParameter("priority");
        String status = request.getParameter("status");
        String assignedEmployeeId = request.getParameter("assignedEmployeeId");

        System.out.println(description);
        System.out.println(deadline);
        System.out.println(priority);
        System.out.println(status);
        System.out.println(assignedEmployeeId);

        int assignedEmployeeIdInt = Integer.parseInt(assignedEmployeeId);

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EmployeeService employeeService = new EmployeeService(new EmployeeRepository(entityManager));
        Employee assignedEmployee = employeeService.getEmployeeById(assignedEmployeeIdInt);


        Task task = new Task(description, deadline, priority, assignedEmployee, status);

        TaskService taskService = new TaskService(new TaskRepository(entityManager));
        taskService.createTask(description, deadline, priority, assignedEmployee, status);

        System.out.println(assignedEmployee);

        response.sendRedirect(request.getContextPath() + "/tasks");
    }

    private LocalDate parseDate(String dateString) {
        if (dateString != null && !dateString.isEmpty()) {
            return LocalDate.parse(dateString);
        }
        return null;
    }


}
