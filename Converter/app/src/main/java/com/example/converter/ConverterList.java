package com.example.converter;

import android.app.Application;

import java.util.ArrayList;

public class ConverterList extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people=new ArrayList<Person>();
        people.add(new Person("Unit Converter","unit"));
        people.add(new Person("Curreny Converter","money"));
        people.add(new Person("Temperature Converter","temperature"));
        people.add(new Person("Speed Converter","speed"));
        people.add(new Person("Area Converter","area"));
    }
}
