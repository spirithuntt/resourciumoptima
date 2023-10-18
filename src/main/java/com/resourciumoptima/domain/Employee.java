package com.resourciumoptima.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Employee {
    //Employé : Attributs : id, nom d'utilisateur, mot de passe, nom, prénom, adresse e-mail, poste, date d'embauche, etc.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String name;
    private String firstname;
    private String email;
    private String position;
    private String hiringDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public Employee() {
    }

    public Employee( String username, String password, String name, String firstname, String email, String position, String hiringDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.firstname = firstname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", hiringDate='" + hiringDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(username, employee.username) && Objects.equals(password, employee.password) && Objects.equals(name, employee.name) && Objects.equals(firstname, employee.firstname) && Objects.equals(email, employee.email) && Objects.equals(position, employee.position) && Objects.equals(hiringDate, employee.hiringDate) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, firstname, email, position, hiringDate, department);
    }
}

