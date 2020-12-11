package com.example.flotinghint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView etFirstName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName=(AutoCompleteTextView) findViewById(R.id.etFirstName);

        String [] name={"Maulik","Manan","Mahesh","Alesh","Kamplesh"};

        ArrayAdapter<String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,name);

        etFirstName.setThreshold(1);
        etFirstName.setAdapter(adapter);


    }
}
