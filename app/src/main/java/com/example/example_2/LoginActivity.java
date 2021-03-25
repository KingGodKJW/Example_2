package com.example.example_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin,btnRegister;
    EditText edtId,edtPw;
    String Id;
    String Pw;
    String Name;
    String Email;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SQLiteDatabase.loadLibs(this);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        edtId = findViewById(R.id.edtId);
        edtPw = findViewById(R.id.edtPw);




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = DBHelper.getInstance(LoginActivity.this).Login(edtId.getText().toString(),edtPw.getText().toString());
                while(cursor.moveToNext()){
                    Id = cursor.getString(cursor.getColumnIndex("ID"));
                    Pw = cursor.getString(cursor.getColumnIndex("PW"));
                    Name = cursor.getString(cursor.getColumnIndex("NAME"));
                    Email = cursor.getString(cursor.getColumnIndex("EMAIL"));
                    System.out.println(Id);
                    System.out.println(Pw);
                    System.out.println(Name);
                    System.out.println(Email);
                }


                Intent intent = new Intent(getApplicationContext(),MainActivity.class);



                    intent.putExtra("Id",Id);
                    startActivity(intent);





            }
        });




    }
}
