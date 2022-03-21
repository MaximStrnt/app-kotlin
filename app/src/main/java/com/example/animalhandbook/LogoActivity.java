package com.example.animalhandbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class LogoActivity extends Activity {



    private Animation logoAnim,buttonLogoAnim ;
    private Button bAnim;
    private ImageView logoImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        init();
        startMainActivity();

    }

    
    
    private void init () {

        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_anim);

        logoImage = findViewById(R.id.logo_image);
        bAnim = findViewById(R.id.button_anim);


        logoImage.startAnimation(logoAnim);
        bAnim.startAnimation(buttonLogoAnim);

    }
    
    
    public void onClickStart(View view) {

        Intent jump = new Intent(LogoActivity.this, MainActivity.class);
        startActivity(jump);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void startMainActivity() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent jump = new Intent(LogoActivity.this, MainActivity.class);
                startActivity(jump);
            }
        }).start();

    }

}
