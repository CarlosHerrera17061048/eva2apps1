package com.example.eva2_4_action_sendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    EditText edt1, edt2;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edtNum);
        edt2 = findViewById(R.id.edtMens);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String sTel,sMens;
        sTel = "smsto:" + edt1.getText().toString();
        sMens = edt2.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));

        intent.putExtra("sms_body",sMens);
        startActivity(intent);
    }
}