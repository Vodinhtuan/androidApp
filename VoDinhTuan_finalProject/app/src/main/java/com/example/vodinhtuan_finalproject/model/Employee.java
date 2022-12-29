package com.example.vodinhtuan_finalproject.model;

public class Employee {
    private String id;
    private boolean gender;
    private String name;

    public Employee() {
    }

    public Employee(String id, boolean gender, String name) {
        this.id = id;
        this.gender = gender;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
