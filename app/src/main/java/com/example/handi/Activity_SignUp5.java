package com.example.handi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.handi.api.Api_Login;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import com.example.handi.api.ApiService;
import com.example.handi.api.Api_Base;


//줄정리 : 컨트롤+알트+L

public class Activity_SignUp5 extends AppCompatActivity {

    //통신(변수 선언)
    private Retrofit retrofit;
    private ApiService apiService;

    private DatePicker datePicker;


    private Button btnJoin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up5);

        datePicker = (DatePicker) findViewById(R.id.dataPicker);
        datePicker.init(2019, 11, 25, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = year + "/" + monthOfYear + "/" + dayOfMonth;
                Toast.makeText(Activity_SignUp5.this, date, Toast.LENGTH_SHORT).show();
            }
        });


        btnJoin = findViewById(R.id.btnJoin);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            //클릭시
            public void onClick(View view) {
                callJoin();
            }


        });


        // START 통신
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.SERVER_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
        // END 통신


    }

    private void callJoin() {

        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", "234");
        params.put("id", "id");
        params.put("name", "이름");
        params.put("password", "비밀번호");
        params.put("m_birth", String.valueOf(datePicker.getYear())
                + String.valueOf(datePicker.getMonth() + 1)
                + String.valueOf(datePicker.getDayOfMonth()));

        apiService.callJoin(params)
                .enqueue(new Callback<Api_Login>() {
                    @Override
                    public void onResponse(Call<Api_Login> call, Response<Api_Login> response) {

                        if (response.isSuccessful()) {
                            Log.d("retro", "========= isSuccessful");
                            Api_Login apiBase = response.body();
                            Log.d("getResult", String.valueOf(apiBase.getResult()));
                            Log.d("getMsg", String.valueOf(apiBase.getMsg()));
                            Log.d("getStrIdx", String.valueOf(apiBase.getStrIdx()));

                            if (apiBase.getResult()) {
                                Log.d("idx", apiBase.getStrIdx());

                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<Api_Login> call, Throwable t) {
                        Log.d("retro", "error =========" + t);

                    }
                });
    }

}