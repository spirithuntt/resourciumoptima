package com.resourciumoptima.domain;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Employee {
    //Employé : Attributs : id, nom d'utilisateur, mot de passe, nom, prénom, adresse e-mail, poste, date d'embauche, etc.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String hiringDate;

    @ManyToMany(mappedBy = "employees")
    private List<Department> departments;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "employee")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "assignedEmployee")
    private List<Task> tasks;





    public Employee() {
    }

    public Employee( String username, String password, String firstname, String lastName, String email, String position, String hiringDate) {
        this.username = username;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.hiringDate = hiringDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", hiringDate='" + hiringDate + '\'' +
                ", departments=" + departments +
                ", role=" + role +
                ", reservations=" + reservations +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(username, employee.username) && Objects.equals(password, employee.password) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(position, employee.position) && Objects.equals(hiringDate, employee.hiringDate) && Objects.equals(departments, employee.departments) && Objects.equals(role, employee.role) && Objects.equals(reservations, employee.reservations) && Objects.equals(tasks, employee.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, email, position, hiringDate, departments, role, reservations, tasks);
    }
}

