package com.resourciumoptima.service;

import com.resourciumoptima.domain.Department;
import com.resourciumoptima.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentServiceTest{

    // createDepartment method saves department to the repository
    @Test
    public void test_create_department_saves_to_repository() {
        // Arrange
        DepartmentRepository mockRepository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(mockRepository);
        Department department = new Department("Test Department", "Test Description", "Test Head");

        // Act
        departmentService.createDepartment(department);

        // Assert
        verify(mockRepository, times(1)).save(department);
    }

    // updateDepartment method updates the department in the repository
    @Test
    public void test_update_department_updates_in_repository() {
        // Arrange
        DepartmentRepository mockRepository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(mockRepository);
        Department department = new Department("Test Department", "Test Description", "Test Head");

        // Act
        departmentService.updateDepartment(department);

        // Assert
        verify(mockRepository, times(1)).update(department);
    }

    // validate method throws IllegalArgumentException if department or department name is null
    @Test
    public void test_validate_throws_exception_if_department_or_name_is_null() {
        // Arrange
        DepartmentService departmentService = new DepartmentService(null);
        Department department = new Department();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> departmentService.validate(department));
    }

    // validate method does not throw an exception if the department and department name are not null
    @Test
    public void test_validate_does_not_throw_exception_if_department_and_name_are_not_null() {
        // Arrange
        DepartmentService departmentService = new DepartmentService(null);
        Department department = new Department("Test Department", "Test Description", "Test Head");

        // Act & Assert
        assertDoesNotThrow(() -> departmentService.validate(department));
    }

    // createDepartment method throws IllegalArgumentException if the department is null
    @Test
    public void test_create_department_throws_exception_if_department_is_null() {
        // Arrange
        DepartmentService departmentService = new DepartmentService(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> departmentService.createDepartment(null));
    }

    // createDepartment method throws IllegalArgumentException if the department name is null
    @Test
    public void test_create_department_throws_exception_if_department_name_is_null() {
        // Arrange
        DepartmentService departmentService = new DepartmentService(null);
        Department department = new Department();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> departmentService.createDepartment(department));
    }

    // updateDepartment method throws IllegalArgumentException if the department is null
    @Test
    public void test_update_department_throws_exception_if_department_is_null() {
        // Arrange
        DepartmentService departmentService = new DepartmentService(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> departmentService.updateDepartment(null));
    }

    // updateDepartment method throws IllegalArgumentException if the department name is null
    @Test
    public void test_update_department_throws_exception_if_department_name_is_null() {
        // Arrange
        DepartmentService departmentService = new DepartmentService(null);
        Department department = new Department();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> departmentService.updateDepartment(department));
    }

    // updateDepartment method updates the department even if the employees list is null
    @Test
    public void test_update_department_updates_even_if_employees_list_is_null() {
        // Arrange
        DepartmentRepository mockRepository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(mockRepository);
        Department department = new Department("Test Department", "Test Description", "Test Head");

        // Act
        departmentService.updateDepartment(department);

        // Assert
        verify(mockRepository, times(1)).update(department);
    }

    // createDepartment method returns the saved department with a generated id
    @Test
    public void test_create_department_returns_saved_department_with_generated_id() {
        // Arrange
        DepartmentRepository mockRepository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(mockRepository);
        Department department = new Department("Test Department", "Test Description", "Test Head");
        when(mockRepository.save(department)).thenReturn(department);

        // Act
        Department savedDepartment = departmentService.createDepartment(department);

        // Assert
        assertEquals(department, savedDepartment);
        assertNotNull(savedDepartment.getId());
    }
}
