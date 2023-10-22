package com.resourciumoptima.service;


import com.resourciumoptima.domain.Department;
import com.resourciumoptima.repository.DepartmentRepository;

public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {
        validate(department);
        return departmentRepository.save(department);
    }

    private void validate(Department department) {
        if(department == null || department.getName() == null){
            throw new IllegalArgumentException("All fields needed");
        }
    }

    public Department updateDepartment(Department department) {
        validate(department);
        departmentRepository.update(department);
        return department;
    }

}
