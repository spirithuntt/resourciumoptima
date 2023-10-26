package com.resourciumoptima.service;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class EmployeeServiceTest {


    // createEmployee method saves a valid employee
    @Test
    public void test_create_employee_valid() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = new Employee("username", "password", "John", "Doe", "john.doe@example.com", "position", "2021-01-01");

        // Act
        Employee result = employeeService.createEmployee(employee);

        // Assert
        verify(mockRepository, times(1)).save(employee);
        assertEquals(employee, result);
    }

    // updateEmployee method updates a valid employee
    @Test
    public void test_update_employee_valid() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = new Employee("username", "password", "John", "Doe", "john.doe@example.com", "position", "2021-01-01");

        // Act
        Employee result = employeeService.updateEmployee(employee);

        // Assert
        verify(mockRepository, times(1)).update(employee);
        assertEquals(employee, result);
    }

    // getEmployeeById method returns a valid employee
    @Test
    public void test_get_employee_by_id_valid() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = new Employee("username", "password", "John", "Doe", "john.doe@example.com", "position", "2021-01-01");
        when(mockRepository.findById(1)).thenReturn(employee);

        // Act
        Employee result = employeeService.getEmployeeById(1);

        // Assert
        verify(mockRepository, times(1)).findById(1);
        assertEquals(employee, result);
    }

    // getAllEmployees method returns a list of employees
    @Test
    public void test_get_all_employees_valid() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("username1", "password1", "John", "Doe", "john.doe@example.com", "position", "2021-01-01"));
        employees.add(new Employee("username2", "password2", "Jane", "Smith", "jane.smith@example.com", "position", "2021-01-01"));
        when(mockRepository.findAll()).thenReturn(employees);

        // Act
        List<Employee> result = employeeService.getAllEmployees();

        // Assert
        verify(mockRepository, times(1)).findAll();
        assertEquals(employees, result);
    }

    // validate method throws an exception if employee is null or any of its required fields are null
    @Test
    public void test_validate_employee_null_or_required_fields_null() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = null;

        // Act & Assert
        Employee finalEmployee3 = employee;
        assertThrows(IllegalArgumentException.class, () -> employeeService.validate(finalEmployee3));

        employee = new Employee("username", null, "John", "Doe", "john.doe@example.com", "position", "2021-01-01");
        Employee finalEmployee2 = employee;
        assertThrows(IllegalArgumentException.class, () -> employeeService.validate(finalEmployee2));

        employee = new Employee("username", "password", null, "Doe", "john.doe@example.com", "position", "2021-01-01");
        Employee finalEmployee1 = employee;
        assertThrows(IllegalArgumentException.class, () -> employeeService.validate(finalEmployee1));

        employee = new Employee("username", "password", "John", null, "john.doe@example.com", "position", "2021-01-01");
        Employee finalEmployee = employee;
        assertThrows(IllegalArgumentException.class, () -> employeeService.validate(finalEmployee));
    }

    // createEmployee method throws an exception if employee email is already taken
    @Test
    public void test_create_employee_email_taken() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = new Employee("username", "password", "John", "Doe", "john.doe@example.com", "position", "2021-01-01");
        when(mockRepository.isEmailTaken("john.doe@example.com")).thenReturn(true);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> employeeService.createEmployee(employee));
    }

    // createEmployee method throws an exception if employee is null
    @Test
    public void test_create_employee_null() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> employeeService.createEmployee(employee));
    }

    // createEmployee method throws an exception if employee email is null
    @Test
    public void test_create_employee_email_null() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = new Employee("username", "password", "John", "Doe", null, "position", "2021-01-01");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> employeeService.createEmployee(employee));
    }

    // createEmployee method throws an exception if employee password is null
    @Test
    public void test_create_employee_password_null() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = new Employee("username", null, "John", "Doe", "john.doe@example.com", "position", "2021-01-01");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> employeeService.createEmployee(employee));
    }

    // createEmployee method throws an exception if employee first name is null
    @Test
    public void test_create_employee_first_name_null() {
        // Arrange
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);
        Employee employee = new Employee("username", "password", null, "Doe", "john.doe@example.com", "position", "2021-01-01");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> employeeService.createEmployee(employee));
    }

}