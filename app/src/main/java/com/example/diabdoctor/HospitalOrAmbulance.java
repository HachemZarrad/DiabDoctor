package com.example.diabdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class HospitalOrAmbulance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_or_ambulance);
    }

    public void ambulance(View v){
        Uri uri = Uri.parse("https://www.google.co.in/maps/search/ambulance near me"); 
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void hospital(View view){
        Uri uri = Uri.parse("https://www.google.co.in/maps/search/hospital near me"); 
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
