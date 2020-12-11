package com.example.challenge_fragmentrecyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked, View.OnClickListener {

    TextView tvName,tvtel,tvCompany;
    Button btnCar,btnOwener;
    ImageView imLogo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName=findViewById(R.id.tvName);
        tvCompany=findViewById(R.id.tvCompany);
        tvtel=findViewById(R.id.tvTel);
        btnCar=findViewById(R.id.btnCar);
        btnOwener=findViewById(R.id.btnOwner);
        imLogo=findViewById(R.id.imLogo);

        btnCar.setOnClickListener(this);
        btnOwener.setOnClickListener(this);

        if (findViewById(R.id.layout_portrait)==null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.logoFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.buttonFrag))
                    .commit();
        }
        if(findViewById(R.id.layout_land)==null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.logoFrag))
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.buttonFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

    }


    @Override
    public void onItemClicked(int i) {
        tvName.setText(CarList.people.get(i).getOwener());
        tvCompany.setText(CarList.people.get(i).getCompany());
        tvtel.setText(CarList.people.get(i).getTelephone());

        if(CarList.people.get(i).getLogo()=="mercedes"){
            imLogo.setImageResource(R.drawable.mercedes);
        }
        else if (CarList.people.get(i).getLogo()=="volkswagen"){
            imLogo.setImageResource(R.drawable.volkswagen);
        }
        else{
            imLogo.setImageResource(R.drawable.nissan);
        }

        if (findViewById(R.id.layout_portrait)!=null){
            tvCompany.setVisibility(View.GONE);
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.logoFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.buttonFrag))
                    .addToBackStack(null)
                    .commit();
        }

    }

    @Override
    public void onClick(View v) {
        if(findViewById(R.id.layout_land)!=null) {
            if (v.getId() == R.id.btnCar) {
                FragmentManager manager = this.getSupportFragmentManager();
                manager.beginTransaction()
                        .show(manager.findFragmentById(R.id.logoFrag))
                        .hide(manager.findFragmentById(R.id.detailFrag))
                        .show(manager.findFragmentById(R.id.listFrag))
                        .show(manager.findFragmentById(R.id.buttonFrag))
                        .commit();
            } else {
                FragmentManager manager = this.getSupportFragmentManager();
                manager.beginTransaction()
                        .hide(manager.findFragmentById(R.id.logoFrag))
                        .show(manager.findFragmentById(R.id.detailFrag))
                        .show(manager.findFragmentById(R.id.listFrag))
                        .show(manager.findFragmentById(R.id.buttonFrag))
                        .commit();
            }
        }
        if (findViewById(R.id.layout_portrait)!=null){
            if (v.getId() == R.id.btnCar) {
                tvCompany.setVisibility(View.VISIBLE);
                FragmentManager manager = this.getSupportFragmentManager();
                manager.beginTransaction()
                        .show(manager.findFragmentById(R.id.logoFrag))
                        .hide(manager.findFragmentById(R.id.detailFrag))
                        .hide(manager.findFragmentById(R.id.listFrag))
                        .show(manager.findFragmentById(R.id.buttonFrag))
                        .commit();
            } else {
                FragmentManager manager = this.getSupportFragmentManager();
                manager.beginTransaction()
                        .hide(manager.findFragmentById(R.id.logoFrag))
                        .show(manager.findFragmentById(R.id.detailFrag))
                        .hide(manager.findFragmentById(R.id.listFrag))
                        .show(manager.findFragmentById(R.id.buttonFrag))
                        .commit();
            }
        }
    }
}
