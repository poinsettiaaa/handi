package com.example.handi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_SignUp3 extends AppCompatActivity {

    private Button btnNext;
    private EditText etid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up3);


        btnNext = findViewById(R.id.btnNext);
        etid = findViewById(R.id.etid);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            //클릭시
            public void onClick(View view) {
                startActivity(new Intent(Activity_SignUp3.this, Activity_SignUp4.class));
            }


        });
    }

}