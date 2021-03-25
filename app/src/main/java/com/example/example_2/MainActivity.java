package com.example.example_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    TextView txtWelcome;
    Button btnLogin,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase.loadLibs(this);


        txtWelcome = findViewById(R.id.txtWelcome);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);


        Intent intent = getIntent();
        String getId = null;
        getId = intent.getStringExtra("Id");




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ee","ee");

                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);

            }
        });

    }
}