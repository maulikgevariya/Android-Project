package com.example.fragmentandrecyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    TextView tvName;
    TextView tvTel;
    EditText etName;
    EditText etTel;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName=findViewById(R.id.tvName);
        tvTel=findViewById(R.id.tvTel);
        etName=findViewById(R.id.etName);
        etTel=findViewById(R.id.etTel);
        btnAdd=findViewById(R.id.btnAdd);
        fragmentManager=this.getSupportFragmentManager();
        listFrag=(ListFrag) fragmentManager.findFragmentById(R.id.FragList);

            btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty() || etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all require field", Toast.LENGTH_SHORT).show();
                }
                else {
                    ApplicationClass.people.add(new Person(etName.getText().toString(),etTel.getText().toString()));
                    Toast.makeText(MainActivity.this, "You Successfully add contact", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etTel.setText(null);
                    listFrag.notifyChange();
                }
            }
        });


    }

    @Override
    public void onItemClicked(int i) {
        tvName.setText(ApplicationClass.people.get(i).getName());
        tvTel.setText(ApplicationClass.people.get(i).getTelephone());
    }
}
