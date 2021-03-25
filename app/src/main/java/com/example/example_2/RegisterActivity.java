package com.example.example_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.sqlcipher.database.SQLiteDatabase;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;

    EditText edtId,edtPw,edtName,edtEmail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SQLiteDatabase.loadLibs(this);

        edtId = findViewById(R.id.edtId);
        edtPw = findViewById(R.id.edtPw);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.getInstance(RegisterActivity.this).register(edtId.getText().toString(),
                                                                    edtPw.getText().toString(),
                                                                    edtName.getText().toString(),
                                                                    edtEmail.getText().toString());

                System.out.print(edtId.getText().toString() +"," + edtPw.getText().toString()+","+edtName.getText().toString()+","+edtEmail.getText().toString());
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
