package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Personadapter.ItemClick {

    RecyclerView recyclerView;
    RecyclerView.Adapter myadapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        //or recyclerView.setLayoutManager(new LinearLayoutManager(this)); without declaration

        people=new ArrayList<Person>();
        people.add(new Person("maulik","Gevariya","bus"));
        people.add(new Person("manan","Gadhiya","plan"));
        people.add(new Person("maulik","Gevariya","bus"));
        people.add(new Person("manan","Gadhiya","plan"));
        people.add(new Person("maulik","Gevariya","bus"));
        people.add(new Person("manan","Gadhiya","plan"));
        people.add(new Person("maulik","Gevariya","bus"));
        people.add(new Person("manan","Gadhiya","plan"));
        people.add(new Person("maulik","Gevariya","bus"));
        people.add(new Person("manan","Gadhiya","plan"));
        people.add(new Person("maulik","Gevariya","bus"));
        people.add(new Person("manan","Gadhiya","plan"));
        people.add(new Person("maulik","Gevariya","bus"));
        people.add(new Person("manan","Gadhiya","plan"));
        people.add(new Person("maulik","Gevariya","bus"));
        people.add(new Person("manan","Gadhiya","plan"));

        myadapter = new Personadapter(this,people);
        recyclerView.setAdapter(myadapter);

    }

    @Override
    public void onItemClick(int i) {
        Toast.makeText(this, "Name: "+people.get(i).getName(), Toast.LENGTH_SHORT).show();
    }
}
