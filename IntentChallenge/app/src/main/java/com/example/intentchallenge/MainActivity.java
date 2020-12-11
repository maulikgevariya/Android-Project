package com.example.intentchallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgSmile;
    ImageView imgCall;
    ImageView imgWeb;
    ImageView imgLocation;
    Button newContact;
    final int ACTIVITY2=2;
    String call,website,location,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgSmile=findViewById(R.id.imgSmile);
        imgCall=findViewById(R.id.imgCall);
        imgWeb=findViewById(R.id.imgWeb);
        imgLocation=findViewById(R.id.imgLocation);
        newContact=findViewById(R.id.newContact);

        imgSmile.setVisibility(View.GONE);
        imgCall.setVisibility(View.GONE);
        imgWeb.setVisibility(View.GONE);
        imgLocation.setVisibility(View.GONE);

        newContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,com.example.intentchallenge.Activity2.class);
                startActivityForResult(intent,ACTIVITY2);
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+call));
                startActivity(intent);
            }
        });

        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+website));
                startActivity(intent);
            }
        });

        imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+location));
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY2){
            if(resultCode==RESULT_OK){
                imgSmile.setVisibility(View.VISIBLE);
                imgCall.setVisibility(View.VISIBLE);
                imgWeb.setVisibility(View.VISIBLE);
                imgLocation.setVisibility(View.VISIBLE);

                call=data.getStringExtra("number");
                website=data.getStringExtra("website");
                location=data.getStringExtra("location");
                image=data.getStringExtra("imsmile");

                if(image.equals("dis")){
                    imgSmile.setImageResource(R.drawable.disagree);
                }
                else{
                    imgSmile.setImageResource(R.drawable.smile);
                }
            }
            if(resultCode==RESULT_CANCELED){
                imgSmile.setVisibility(View.GONE);
                imgCall.setVisibility(View.GONE);
                imgWeb.setVisibility(View.GONE);
                imgLocation.setVisibility(View.GONE);
            }
        }
    }

}
