package com.example.eco_hotel;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1;

    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DataBaseHelper(this);

        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.pass);
        b1 = (Button) findViewById(R.id.signin);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = e1.getText().toString();
                String password = e2.getText().toString();

//                Intent intent = new Intent(LoginActivity.this, MiddleActivity.class);
//
//                startActivity(intent);

                Boolean chkEmailPassword = db.chkEmailPassword(email,password);

                if(chkEmailPassword){
                    middle();
                    Toast.makeText(getApplicationContext(),"Successfually sign in",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrect emaill or password",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    public void middle() {
        Intent intent = new Intent(this,MiddleActivity.class);
        startActivity(intent);
    }

    public void reg(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
