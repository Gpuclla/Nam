package com.example.am;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private static final long SPLASH_SCREEN_DELAY = 3000;
    Animation topanima, bottonanim;
    ImageView img1;
    static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        topanima= AnimationUtils.loadAnimation(this,R.anim.top_animacion);
        bottonanim= AnimationUtils.loadAnimation(this,R.anim.boton_animacion);
        img1=findViewById(R.id.img1);


        img1.setAnimation(topanima);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent().setClass(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_DELAY);

    }
}