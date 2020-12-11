package com.example.challenge_fragmentrecyclerview;

public class Person {
    private String company;
    private String owener;
    private String telephone;
    private String logo;

    public Person(String company, String owener, String telephone, String logo) {
        this.company = company;
        this.owener = owener;
        this.telephone = telephone;
        this.logo = logo;
    }

    public String getCompany() {
        return company;
    }

    public String getOwener() {
        return owener;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getLogo() {
        return logo;
    }
}
