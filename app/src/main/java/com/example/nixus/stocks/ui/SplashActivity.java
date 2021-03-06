package com.example.nixus.stocks.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.nixus.stocks.R;

/**
 * Created by nixus on 22.01.2018.
 */

public class SplashActivity extends AppCompatActivity {

    private static final int INTERVAL = 1500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();

            }
        }, INTERVAL);
    }
}
