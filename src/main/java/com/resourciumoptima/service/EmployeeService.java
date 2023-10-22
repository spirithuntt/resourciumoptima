package com.resourciumoptima.service;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.repository.EmployeeRepository;

public class EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee createEmployee(Employee employee) {
        validate(employee);
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Employee employee) {
        validate(employee);
        employeeRepository.update(employee);
        return employee;
    }
    public Employee getEmployeeById(int id) {
        System.out.println("EmployeeService getEmployeeById");
        System.out.println(id);
        return employeeRepository.findById(id);
    }
        private void validate(Employee employee) {
            if(employee == null || employee.getEmail() == null || employee.getPassword() == null || employee.getFirstName() == null || employee.getLastName() == null){
                throw new IllegalArgumentException("All fields needed");
            }
            if (!isValidEmail(employee.getEmail())) {
                throw new IllegalArgumentException("Email not valid");
            }
            if (!isValidPassword(employee.getPassword())) {
                throw new IllegalArgumentException("password not valid");
            }
        }

    private boolean isValidEmail(String email) {
        return email.contains("@") && !employeeRepository.isEmailTaken(email);
    }

    private boolean isValidPassword(String password) {
        return password.length() > 3;
    }

}
