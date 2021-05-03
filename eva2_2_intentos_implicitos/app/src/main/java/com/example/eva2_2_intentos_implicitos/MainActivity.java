package com.example.eva2_2_intentos_implicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

              a  = new Intent(this,activity2.class);

    }
    public  void onClick(View v){
        startActivity(a);
    }
}