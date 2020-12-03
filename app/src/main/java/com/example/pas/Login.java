package com.example.pas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText user, password;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = getSharedPreferences("login", MODE_PRIVATE);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mUser = user.getText().toString();
                String mPassword = password.getText().toString();

                if (mUser.equalsIgnoreCase("salah") && mPassword.equalsIgnoreCase("salah")){
                    Toast.makeText(Login.this,"Anda salah", Toast.LENGTH_LONG).show();
                }else {
                    editor = pref.edit();
                    editor.putString("username", mUser);
                    editor.putString("status", "login");
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

            }
        });
    }
}