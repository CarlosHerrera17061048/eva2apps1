package com.example.evva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre,edtEdad,edtDeposito;
    CheckBox checkboxinfo;
    RadioButton rdSnk,rdDb,rdDn,rdNnt;
    RadioGroup rdgAnime;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent =  new Intent(this,Activity2.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtNombre = findViewById(R.id.edtNombre);
        edtEdad = findViewById(R.id.edtEdad);
        edtDeposito =  findViewById(R.id.edtDeposito);
        rdgAnime =  findViewById(R.id.rdgAnime);
        checkboxinfo = findViewById(R.id.cbInfoAdicional);


    }

    public void onClick(View v){
        intent.putExtra("NOMBRE", edtNombre.getText().toString());
        int edad = 0;
        edad = Integer.parseInt(edtEdad.getText().toString());
        double deposito = 0.0;
        deposito = Double.parseDouble(edtDeposito.getText().toString());

        intent.putExtra("EDAD",edad);
        intent.putExtra("DEPOSITO",deposito);
        intent.putExtra("INFO",checkboxinfo.isChecked());
        intent.putExtra("ANIME_FAVORITO",rdgAnime.getCheckedRadioButtonId());
        startActivity(intent);


    }

}