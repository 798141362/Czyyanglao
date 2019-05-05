package com.example.lenovo1.application1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new  Runnable() {
            @Override
            public void run() {
                Intent intent1=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent1);
                SplashActivity.this.finish();
            }
        },3000);

    }
}
