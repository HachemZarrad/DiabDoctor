package com.example.diabdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
    }

    public void emergency(View v){
        Intent i = new Intent(this, HospitalOrAmbulance.class);
        startActivity(i);
    }
    public void help(View v){
        Intent i = new Intent(this, PhoneCall.class);
        startActivity(i);
    }
}
