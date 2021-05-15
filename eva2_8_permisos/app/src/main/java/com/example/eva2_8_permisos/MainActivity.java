package com.example.eva2_8_permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static int permisoLLamar = 100;
    Button btnLLamar;
    Intent intent;
    EditText edtTxt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLLamar = findViewById(R.id.btnLlamar);
        //Verificar si tengo el permiso
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
        //Solicitar Permiso
            Toast.makeText(this,"No tienes Permisos",Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},permisoLLamar);
            btnLLamar.setEnabled(false);
        }else{
            //Ejecutar accion si la app tiene permiso
            Toast.makeText(this,"tienes Permisos",Toast.LENGTH_LONG).show();
            btnLLamar.setEnabled(true);
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        edtTxt1 = findViewById(R.id.edtTxt1);

    }
    public void onCick(View v){
    String sTel = "tel:"+ edtTxt1.getText().toString();
    intent = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
    startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
           case  permisoLLamar:
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                btnLLamar.setEnabled(true);
                Toast.makeText(this,"Permiso concedido",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"Permiso denegado",Toast.LENGTH_LONG).show();
            }
            break ;
        }
    }
}