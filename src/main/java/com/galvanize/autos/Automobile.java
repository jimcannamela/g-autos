package com.galvanize.autos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Automobile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;
    private String make;
    private String model;

    public Automobile() {
    }

    public Automobile(String year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
}
