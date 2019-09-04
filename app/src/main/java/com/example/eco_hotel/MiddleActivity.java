package com.example.eco_hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MiddleActivity extends AppCompatActivity {

    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        mydb = new DataBaseHelper(this);
    }

    public void profile(View view) {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);

    }
}