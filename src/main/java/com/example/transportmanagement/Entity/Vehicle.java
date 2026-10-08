package com.example.transportmanagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String make;
    private String model;
    private int year;
    private String color;

    @Column(unique = true)
    private String registrationNumber;

    public Vehicle(String make, String model, int year,
                   String color, String registrationNumber) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    public Vehicle() {

    }

    public Long getId() {
        return vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
