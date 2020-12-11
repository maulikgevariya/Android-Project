package com.example.challenge_fragmentrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class CarList extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people=new ArrayList<Person>();
        people.add(new Person("POLO","Maulik","1234567890","volkswagen"));
        people.add(new Person("E200","Manan","9876543210","mercedes"));
        people.add(new Person("Almera","Peter","12345667894","nissan"));
        people.add(new Person("E180","Maulik","1234567890","mercedes"));
        people.add(new Person("E200","Manan","9876543210","volkswagen"));
        people.add(new Person("Almera","Peter","12345667894","nissan"));
    }
}
