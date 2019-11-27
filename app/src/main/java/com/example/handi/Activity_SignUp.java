package com.example.handi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.handi.api.ApiService;
import com.example.handi.api.Api_Base;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_SignUp extends AppCompatActivity {

    public Activity activity;

    //통신(변수 선언)
    private Retrofit retrofit;
    private ApiService apiService;

    private TextView tvEmail;
    private TextView tvTel;
    private EditText etEmail;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        //아이디 변수 연결
        tvEmail = findViewById(R.id.tvEmail);
        tvTel = findViewById(R.id.tvTel);
        etEmail = findViewById(R.id.etEmail);
        btnNext = findViewById(R.id.btnNext);

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.SERVER_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        activity = Activity_SignUp.this;


        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            //클릭시
            public void onClick(View view) {
                //텍스트 컬러 변경
                tvEmail.setTextColor(Color.parseColor("#000000"));
                tvTel.setTextColor(Color.parseColor("#aaaaaa"));

                //힌트 변경
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

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //텍스트값이 공란일 경우
                if (etEmail.getText().toString().equals("")) {
                    Toast.makeText(activity, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    //돌아감
                    return;
                }

                //이메일 형식이 아닐 경우
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches())
                {
                    Toast.makeText(activity, "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //위의 조건이 일치할 경우 아래 함수 호출
                callSignUpEmail();
            }

        });

    }


    private void callSignUpEmail() {

        HashMap<String, String> params = new HashMap<>();
        params.put("m_email", etEmail.getText().toString());

        apiService.callCheckEmail(params)
                .enqueue(new Callback<Api_Base>() {
                    @Override
                    public void onResponse(Call<Api_Base> call, Response<Api_Base> response) {

                        //응답이 정상인 경우
                        if (response.isSuccessful()) {
                            Log.d("retro", "========= isSuccessful");
                            Api_Base apiBase = response.body();

                            if (apiBase.getResult()) {
                                Toast.makeText(activity, "사용 가능한 이메일입니다.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Activity_SignUp.this, Activity_SignUp3.class));
                            } else {
                                Toast.makeText(activity, apiBase.getMsg(), Toast.LENGTH_SHORT).show();
                            }

                        //응답이 정상이 아닌 경우
                        } else {
                            Toast.makeText(activity, "알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Api_Base> call, Throwable t) {
                        Log.d("retro", "error =========" + t);

                    }
                });
    }


}