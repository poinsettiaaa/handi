package com.example.handi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_SignUp5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up5);
    }

    private DatePicker datePicker;
    DatePicker datePicker = (DatePicker)findViewById(R.id.dataPicker);
        datePicker.init(2019, 11, 25, new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String date = year + "/" + monthOfYear + "/" + dayOfMonth;
            Toast.makeText(Activity_SignUp5.this, date, Toast.LENGTH_SHORT).show();
        }
    });
}
