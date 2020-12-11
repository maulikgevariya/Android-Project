package com.example.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {


    private Toolbar hToolbar;
    private EditText name;
    private EditText employee_id;
    private EditText department;
    private EditText institute;
    private EditText mobile;
    private EditText pan;
    private Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        hToolbar = findViewById(R.id.home_screen_toolbar);
        setSupportActionBar(hToolbar);
        getSupportActionBar().setTitle("Income Tax Calculator 2019");

        name=findViewById(R.id.name_et);
        employee_id=findViewById(R.id.employee_et);
        department=findViewById(R.id.department_et);
        institute=findViewById(R.id.institute_et);
        mobile=findViewById(R.id.mobile_et);
        pan=findViewById(R.id.mobile_et);
        next_button=findViewById(R.id.submit_button);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserToBasicActivty();
            }
        });



    }

    private void sendUserToBasicActivty(){
        Intent home_to_basic = new Intent(HomeActivity.this,BasicActivity.class);
        startActivity(home_to_basic);
    }
}
