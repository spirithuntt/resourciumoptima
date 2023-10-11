package com.resourciumoptima.service;

import com.resourciumoptima.domain.Employee;
import com.resourciumoptima.repository.EmployeeRepository;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

}
