package com.example.myfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    EditText etNumber;
    TextView twfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber=findViewById(R.id.etNumber);
        calculate=findViewById(R.id.calculate);
        twfinal=findViewById(R.id.twfinal);
        twfinal.setVisibility(View.GONE);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter require field", Toast.LENGTH_SHORT).show();
                }
                else {
                    int number = Integer.parseInt(etNumber.getText().toString());
                    number = (number / 3) + 4;

                    String final1 = "The approximent Tempeature outside is " + number + " degree celsius";
                    twfinal.setText(final1);
                    twfinal.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
