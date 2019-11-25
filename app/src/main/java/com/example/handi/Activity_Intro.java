package com.example.handi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Intro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);


        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //startActivity(intent);
                startActivity(new Intent(Activity_Intro.this, Activity_Intro.class));
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0, 3000);
    }
}

public class Activity_Login extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
}