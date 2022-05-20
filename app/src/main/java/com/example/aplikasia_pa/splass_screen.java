package com.example.aplikasia_pa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splass_screen extends AppCompatActivity {
    private int Sleep = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splass_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent MainActivity = new Intent(splass_screen.this, MainActivity.class);
                startActivity(MainActivity);
                finish();
            }
        }, Sleep);

    }
}


