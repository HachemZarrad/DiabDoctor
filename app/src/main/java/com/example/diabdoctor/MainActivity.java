package com.example.diabdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void docReg(View v){
        Intent intent = new Intent(this, DocRegister.class);
        startActivity(intent);

    }
    public void patientReg(View v){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
