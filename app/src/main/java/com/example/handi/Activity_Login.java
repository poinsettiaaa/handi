package com.example.handi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sign_up);
        TextView tvFindId = (TextView) findViewById(R.id.tvFindId);
        Intent intent = getIntent();
        tvFindId.setText(intent.getStringExtra("tvFindId")).toString());
    }
}
