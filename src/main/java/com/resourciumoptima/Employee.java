package com.resourciumoptima;


import javax.persistence.*;

@Entity
public class Employee {
    //Employé : Attributs : id, nom d'utilisateur, mot de passe, nom, prénom, adresse e-mail, poste, date d'embauche, etc.

    @Id
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column (name = "name")
    private String name;
    @Column (name = "firstname")
    private String firstname;
    @Column (name = "email")
    private String email;
    @Column (name = "position")
    private String position;
    @Column (name = "hiringDate")
    private String hiringDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

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
}

