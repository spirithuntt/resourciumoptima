package com.resourciumoptima.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Task {
    //Tâche : Attributs : identifiant, description, date limite, priorité, employé assigné, statut, etc.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    private String deadline;

    private String priority;

    private String assignedEmployee;

    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Task() {
    }

    public Task(String description, String deadline, String priority, String assignedEmployee, String status) {
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.assignedEmployee = assignedEmployee;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", priority='" + priority + '\'' +
                ", assignedEmployee='" + assignedEmployee + '\'' +
                ", status='" + status + '\'' +
                ", employee=" + employee +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(description, task.description) && Objects.equals(deadline, task.deadline) && Objects.equals(priority, task.priority) && Objects.equals(assignedEmployee, task.assignedEmployee) && Objects.equals(status, task.status) && Objects.equals(employee, task.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, deadline, priority, assignedEmployee, status, employee);
    }
}
