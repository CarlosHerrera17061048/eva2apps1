package com.example.eva2_5_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnMain;
final int CODIGO_SECUN = 100;
final int CODIGO_CONTACTOS = 1000;
final int CODIGO_GALERIA = 10000;
    Intent intent,intentCont,intentGal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent= new Intent(this,Secundaria.class);
        intentCont = new Intent(Intent.ACTION_PICK,android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentGal = new Intent(Intent.ACTION_PICK, Uri.parse("content://media/external/images/media"));



    }
    public void onClickContactos(View v){
        if(v.getId()==R.id.btn2){
            startActivityForResult(intentGal,CODIGO_GALERIA);
        }else if(v.getId() == R.id.btn3){
            startActivityForResult(intentCont,CODIGO_CONTACTOS);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        btnMain = findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent.putExtra("DATOS", "Informacion Enviada desde Principal!!");

            startActivityForResult(intent,CODIGO_SECUN);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Aqui procesamos la respuesta de la actividad
        //Identificar la actividad que devolvio el resultado
        //Identificar si  se devolvio un valor o no
        // Leer datos INTENT

        switch (requestCode){
            case CODIGO_SECUN:
                if (resultCode == Activity.RESULT_OK){// Si me devolvio un valor
                    Toast.makeText(this,data.getStringExtra("VALOR"),Toast.LENGTH_SHORT).show();
                }
            break;
            case CODIGO_CONTACTOS:
                if (resultCode == Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this,returnedData,Toast.LENGTH_SHORT).show();
                }
                break;
            case CODIGO_GALERIA:
                if (resultCode == Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this,returnedData,Toast.LENGTH_SHORT).show();
                }
            default:
        }
    }
}