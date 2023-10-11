package com.resourciumoptima;

public class Equipment {
    // Attributs : id, nom, type, date d'achat, date de maintenance, état, etc.
    private int id;
    private String name;
    private String type;
    private String purchaseDate;
    private String maintenanceDate;
    private String state;

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
}
