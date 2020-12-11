package com.example.fragmentandrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people=new ArrayList<Person>();
        people.add(new Person("Maulik","9712702398"));
        people.add(new Person("Manan","0123456789"));
    }
}
