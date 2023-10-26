package com.resourciumoptima.service;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.domain.Task;
import com.resourciumoptima.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {


    // can retrieve a task by id
    @Test
    public void test_retrieve_task_by_id() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a dummy task
        Task dummyTask = new Task("Dummy Task", "2022-01-01", "High", new Employee(), "Pending");
    
        // Set up the mock repository to return the dummy task when findById is called
        Mockito.when(mockRepository.findById(1)).thenReturn(dummyTask);
    
        // Call the getTaskById method and assert that it returns the dummy task
        Task retrievedTask = taskService.getTaskById(1);
        assertEquals(dummyTask, retrievedTask);
    }

    // can retrieve all tasks
    @Test
    public void test_retrieve_all_tasks() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a list of dummy tasks
        List<Task> dummyTasks = new ArrayList<>();
        dummyTasks.add(new Task("Task 1", "2022-01-01", "High", new Employee(), "Pending"));
        dummyTasks.add(new Task("Task 2", "2022-01-02", "Medium", new Employee(), "In Progress"));
    
        // Set up the mock repository to return the dummy tasks when findAll is called
        Mockito.when(mockRepository.findAll()).thenReturn(dummyTasks);
    
        // Call the getAllTasks method and assert that it returns the dummy tasks
        List<Task> retrievedTasks = taskService.getAllTasks();
        assertEquals(dummyTasks, retrievedTasks);
    }

    // can create a task with valid attributes
    @Test
    public void test_create_task_with_valid_attributes() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a dummy task
        Task dummyTask = new Task("Dummy Task", "2022-01-01", "High", new Employee(), "Pending");
    
        // Call the createTask method
        taskService.createTask(dummyTask.getDescription(), dummyTask.getDeadline(), dummyTask.getPriority(), dummyTask.getAssignedEmployee(), dummyTask.getStatus());
    
        // Verify that the save method of the mock repository is called with the dummy task
        Mockito.verify(mockRepository).save(dummyTask);
    }

    // can update a task with valid attributes
    @Test
    public void test_update_task_with_valid_attributes() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a dummy task
        Task dummyTask = new Task("Dummy Task", "2022-01-01", "High", new Employee(), "Pending");
    
        // Set up the mock repository to return the dummy task when findById is called
        Mockito.when(mockRepository.findById(1)).thenReturn(dummyTask);
    
        // Call the updateTask method
        taskService.updateTask(1, "Updated Task", "2022-01-02", "Medium", new Employee(), "In Progress");
    
        // Verify that the update method of the mock repository is called with the updated task
        Mockito.verify(mockRepository).update(dummyTask);
    }

    // can delete a task by id
    @Test
    public void test_delete_task_by_id() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Call the deleteTask method
        taskService.deleteTask(1);
    
        // Verify that the delete method of the mock repository is called with the correct task ID
        Mockito.verify(mockRepository).delete(1);
    }

    // throws an error when trying to create a task with null description
    @Test
    public void test_create_task_with_null_description() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a dummy task with null description
        Task dummyTask = new Task(null, "2022-01-01", "High", new Employee(), "Pending");
    
        // Call the createTask method and assert that it throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask(dummyTask.getDescription(), dummyTask.getDeadline(), dummyTask.getPriority(), dummyTask.getAssignedEmployee(), dummyTask.getStatus());
        });
    }

    // throws an error when trying to create a task with null deadline
    @Test
    public void test_create_task_with_null_deadline() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a dummy task with null deadline
        Task dummyTask = new Task("Dummy Task", null, "High", new Employee(), "Pending");
    
        // Call the createTask method and assert that it throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask(dummyTask.getDescription(), dummyTask.getDeadline(), dummyTask.getPriority(), dummyTask.getAssignedEmployee(), dummyTask.getStatus());
        });
    }

    // throws an error when trying to create a task with null priority
    @Test
    public void test_create_task_with_null_priority() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a dummy task with null priority
        Task dummyTask = new Task("Dummy Task", "2022-01-01", null, new Employee(), "Pending");
    
        // Call the createTask method and assert that it throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask(dummyTask.getDescription(), dummyTask.getDeadline(), dummyTask.getPriority(), dummyTask.getAssignedEmployee(), dummyTask.getStatus());
        });
    }

    // throws an error when trying to create a task with null assigned employee
    @Test
    public void test_create_task_with_null_assigned_employee() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a dummy task with null assigned employee
        Task dummyTask = new Task("Dummy Task", "2022-01-01", "High", null, "Pending");
    
        // Call the createTask method and assert that it throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask(dummyTask.getDescription(), dummyTask.getDeadline(), dummyTask.getPriority(), dummyTask.getAssignedEmployee(), dummyTask.getStatus());
        });
    }

    // throws an error when trying to create a task with null status
    @Test
    public void test_create_task_with_null_status() {
        // Create a mock TaskRepository
        TaskRepository mockRepository = Mockito.mock(TaskRepository.class);
    
        // Create a TaskService object with the mock repository
        TaskService taskService = new TaskService(mockRepository);
    
        // Create a dummy task with null status
        Task dummyTask = new Task("Dummy Task", "2022-01-01", "High", new Employee(), null);
    
        // Call the createTask method and assert that it throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask(dummyTask.getDescription(), dummyTask.getDeadline(), dummyTask.getPriority(), dummyTask.getAssignedEmployee(), dummyTask.getStatus());
        });
    }

}