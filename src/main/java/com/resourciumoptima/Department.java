package com.resourciumoptima;



import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    //Attributs : id, nom, description, chef de département, etc.
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "departmentHead")
    private String departmentHead;

    @OneToMany(mappedBy = "department")
    List<Employee> employees;

    public Department() {
    }

    public Department(String name, String description, String departmentHead) {
        this.name = name;
        this.description = description;
        this.departmentHead = departmentHead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", departmentHead='" + departmentHead + '\'' +
                '}';
    }
}
