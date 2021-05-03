package com.example.evva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
intent = getIntent();
       String sNam= intent.getStringExtra("NOMBRE");
       int iEdad = intent.getIntExtra("EDAD",0);
       double deposito = intent.getDoubleExtra("DEPOSITO",0.0);
       boolean binfo = intent.getBooleanExtra("INFO",false);
       int Anime = intent.getIntExtra("ANIME_FAVORITO",0);
        TextView textView;

        textView = findViewById(R.id.txtView);

        textView.append("Nombre: \n");
        textView.append(  sNam+"\n");
        textView.append("Edad: \n");
        textView.append( iEdad+" \n");
        textView.append("Deposito: \n");
        textView.append( deposito+ " \n");
        textView.append("Informacion: \n");
        if(binfo == true)
            textView.append("Con informacin\n");
        else
                    textView.append("Sin informacion\n");

        textView.append("Anime Favorito: \n");
        textView.append(Anime +" \n");


    }
    public void onClick2(View v){
    finish();
    }
}