package com.example.handi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;

public class Activity_Login extends AppCompatActivity {

    private TextView tvSignup;

    private ISessionCallback callback;

    //카카오 버튼
    private Button btn_custom_login;
    private LoginButton btn_kakao_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        callback = new ISessionCallback() {
            @Override
            public void onSessionOpened() {
                Log.d("111111","4444444");
                requestMe();
            }

            @Override
            public void onSessionOpenFailed(KakaoException exception) {

                Log.d("111111","3333333");
            }
        };

        Session.getCurrentSession().addCallback(callback);

        tvSignup = findViewById(R.id.tvSignup);


        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Login.this, Activity_SignUp.class));
            }

        });



        btn_kakao_login = (LoginButton) findViewById(R.id.btn_kakao_login);
        //카카오 로그인
        btn_custom_login = (Button) findViewById(R.id.btn_custom_login);
        btn_custom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("1111111","111111");

                btn_kakao_login.performClick();
            }

        });

    }
    private void requestMe() {

        Log.d("111111","22222222");


        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {

            }

            @Override
            public void onNotSignedUp() {

            }

            @Override
            public void onSuccess(UserProfile result) {

                Log.d("result :",result.getNickname());

            }
        });


    }
}