package com.resourciumoptima.servlets;


import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.domain.Task;
import com.resourciumoptima.repository.EmployeeRepository;
import com.resourciumoptima.repository.TaskRepository;
import com.resourciumoptima.service.EmployeeService;
import com.resourciumoptima.service.TaskService;
import com.resourciumoptima.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "TaskServlet", value = "/createTask")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

//        response.sendRedirect(request.getContextPath() + "/tasks");
    }

    private LocalDate parseDate(String dateString) {
        if (dateString != null && !dateString.isEmpty()) {
            return LocalDate.parse(dateString);
        }
        return null;
    }


}
