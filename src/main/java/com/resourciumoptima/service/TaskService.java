package com.resourciumoptima.service;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.domain.Task;
import com.resourciumoptima.repository.TaskRepository;

import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String description, String deadline, String priority, Employee assignedEmployee, String status) {
        Task task = new Task(description, deadline, priority, assignedEmployee, status);
        task.setDescription(description);
        task.setDeadline(deadline);
        task.setPriority(priority);
        task.setAssignedEmployee(assignedEmployee);
        task.setStatus(status);
        validate(task);
        taskRepository.save(task);
    }

    // Updated the updateTask method to accept task attributes and assigned employee
    public void updateTask(int taskId, String description, String deadline, String priority, Employee assignedEmployee, String status) {
        Task task = taskRepository.findById(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }


        task.setDescription(description);
        task.setDeadline(deadline);
        task.setPriority(priority);
        task.setAssignedEmployee(assignedEmployee);
        task.setStatus(status);

        validate(task);
        taskRepository.update(task);
    }

    public void deleteTask(int id) {
        taskRepository.delete(id);
    }

    private void validate(Task task) {
        System.out.println("assigned employee in validate " + task.getAssignedEmployee());
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description is required.");
        }
        if (task.getDeadline() == null || task.getDeadline().isEmpty()) {
            throw new IllegalArgumentException("Deadline is required.");
        }
        if (task.getPriority() == null || task.getPriority().isEmpty()) {
            throw new IllegalArgumentException("Priority is required.");
        }
        if (task.getAssignedEmployee() == null) {
            throw new IllegalArgumentException("Assigned Employee is required.");
        }
        if (task.getStatus() == null || task.getStatus().isEmpty()) {
            throw new IllegalArgumentException("Status is required.");
        }
    }
}
