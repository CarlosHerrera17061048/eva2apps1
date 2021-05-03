package com.example.eva2_1_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
public static final String Tel="tel:5555";

Intent inTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClicDial(View v){
inTel = new Intent(Intent.ACTION_DIAL, Uri.parse(Tel));
startActivity(inTel);
    }
    public void onClickCall(View v){
        inTel = new Intent(Intent.ACTION_CALL, Uri.parse(Tel));
        startActivity(inTel);
    }

    public void onClickContactos(View v){
        String sData = "content://contacts/people/";
        inTel = new Intent(Intent.ACTION_VIEW, Uri.parse(sData));
        startActivity(inTel);
    }

    public void OnClickWeb(View v){
String wurl="http://youtube.com";
       Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(wurl));
        startActivity(intent);
    }
}