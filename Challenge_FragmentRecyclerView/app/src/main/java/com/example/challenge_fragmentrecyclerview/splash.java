package com.example.challenge_fragmentrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    ImageView ivNissan;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivNissan=findViewById(R.id.ivNissan);
        tvWelcome=findViewById(R.id.tvWelcome);

        Animation myani = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tvWelcome.startAnimation(myani);
        ivNissan.startAnimation(myani);

        final Intent i=new Intent(this,MainActivity.class);

        Thread timer =new Thread()
        {
            public void run () {
                try{
                    sleep(5000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(i);
                    finish();
                }
            }
        };
            timer.start();
    }
}
