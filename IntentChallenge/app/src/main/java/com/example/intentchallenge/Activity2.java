package com.example.intentchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{
    EditText etName;
    EditText etNumber;
    EditText etWebsite;
    EditText etLocation;
    ImageView imSmile;
    ImageView imDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etName=findViewById(R.id.etName);
        etNumber=findViewById(R.id.etNumber);
        etWebsite=findViewById(R.id.etWebsite);
        etLocation=findViewById(R.id.etLocation);
        imSmile=findViewById(R.id.imSmile);
        imDis=findViewById(R.id.imDis);

        imSmile.setOnClickListener(this);
        imDis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() ||
                etWebsite.getText().toString().isEmpty() ||etLocation.getText().toString().isEmpty() ){
            Toast.makeText(this, "Please enter all require field", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent();
            intent.putExtra("name",etName.getText().toString());
            intent.putExtra("number",etNumber.getText().toString());
            intent.putExtra("website",etWebsite.getText().toString());
            intent.putExtra("location",etLocation.getText().toString());

            if(v.getId()== R.id.imSmile){
                intent.putExtra("imsmile","smile");
            }
            else{
                intent.putExtra("imsmile","dis");
            }
            setResult(RESULT_OK,intent);
            Activity2.this.finish();
        }
    }
}
