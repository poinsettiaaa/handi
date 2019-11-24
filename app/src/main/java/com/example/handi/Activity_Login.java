package com.example.handi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Activity_Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sign_in);
        TextView tvFindId = (TextView) findViewById(R.id.tvFindId);
        Intent intent = getIntent();
        tvFindId.setText(intent.getStringExtra("tvFindId")).toString());
    }
}
