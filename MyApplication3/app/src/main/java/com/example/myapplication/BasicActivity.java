package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class BasicActivity extends AppCompatActivity {


    private Toolbar bToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        bToolbar = findViewById(R.id.basic_screen_toolbar);
        setSupportActionBar(bToolbar);
        getSupportActionBar().setTitle("Basic Details");


    }
}
