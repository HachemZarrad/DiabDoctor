package com.example.diabdoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DocRegister extends AppCompatActivity {
    EditText emailId, password,userName,phoneNumber,city,speciality;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_register);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.editText1);
        phoneNumber = findViewById(R.id.editText4);
        city = findViewById(R.id.editText5);
        emailId = findViewById(R.id.editText2);
        speciality = findViewById(R.id.editText6);
        password = findViewById(R.id.editText3);
        btnSignUp = findViewById(R.id.button3);
        tvSignIn = findViewById(R.id.textView);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                String phone = phoneNumber.getText().toString().trim();
                String City = city.getText().toString().trim();
                String user = userName.getText().toString().trim();
                String Speciality = speciality.getText().toString().trim();

                if(email.isEmpty()){
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(DocRegister.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty() && user.isEmpty() && phone.isEmpty() && City.isEmpty()) ){
                    HashMap<String,String> dataMap = new HashMap<String, String>();
                    dataMap.put("userName",user);
                    dataMap.put("email",email);
                    dataMap.put("password",pwd);
                    dataMap.put("phone",phone);
                    dataMap.put("city",City);
                    dataMap.put("speciality",Speciality);
                    mDatabase.push().setValue(dataMap);

                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(DocRegister.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(DocRegister.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(DocRegister.this, PatientHome.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(DocRegister.this,"Error Occurred! or one of the fields is empty",Toast.LENGTH_SHORT).show();

                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DocRegister.this, DocLogin.class);
                startActivity(i);
            }
        });
    }
}
