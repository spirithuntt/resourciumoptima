package com.resourciumoptima.domain;

import jakarta.persistence.*;

import java.util.Objects;

public class Equipment {
    // Attributs : id, nom, type, date d'achat, date de maintenance, état, etc.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column (name = "purchaseDate")
    private String purchaseDate;
    @Column (name = "maintenanceDate")
    private String maintenanceDate;
    @Column (name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Equipment() {
    }

    public Equipment(String name, String type, String purchaseDate, String maintenanceDate, String state) {
        this.name = name;
        this.type = type;
        this.purchaseDate = purchaseDate;
        this.maintenanceDate = maintenanceDate;
        this.state = state;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", maintenanceDate='" + maintenanceDate + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return id == equipment.id && Objects.equals(name, equipment.name) && Objects.equals(type, equipment.type) && Objects.equals(purchaseDate, equipment.purchaseDate) && Objects.equals(maintenanceDate, equipment.maintenanceDate) && Objects.equals(state, equipment.state) && Objects.equals(employee, equipment.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, purchaseDate, maintenanceDate, state, employee);
    }
}
