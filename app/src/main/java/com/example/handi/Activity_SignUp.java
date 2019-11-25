package com.example.handi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_SignUp extends AppCompatActivity {

    private TextView tvEmail;
    private TextView tvTel;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        tvEmail = findViewById(R.id.tvEmail);
        tvTel = findViewById(R.id.tvTel);
        etEmail = findViewById(R.id.etEmail);

        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvEmail.setTextColor(Color.parseColor("#000000"));
                tvTel.setTextColor(Color.parseColor("#aaaaaa"));
                etEmail.setHint("이메일을 입력하세요");
            }


        });

        tvTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTel.setTextColor(Color.parseColor("#000000"));
                tvEmail.setTextColor(Color.parseColor("#aaaaaa"));
                etEmail.setHint("전화번호를 입력하세요");
            }
        });

    }
}