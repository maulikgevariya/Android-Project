package com.example.converter;

public class Person {
    private String Name;
    private String logo;

    public Person(String name, String logo) {
        Name = name;
        this.logo = logo;
    }

    public String getName() {
        return Name;
    }

    public String getLogo() {
        return logo;
    }
}

