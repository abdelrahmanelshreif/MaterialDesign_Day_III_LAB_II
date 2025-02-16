package com.example.material_design_3rd_day_2nd_lab;


public class Mobile {
    String title;
    String description;

    String brand;

    public Mobile() {

    }

    public Mobile(String brand, String title, String description) {
        this.title = title;
        this.description = description;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String title) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
