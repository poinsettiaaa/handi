package com.example.handi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;

public class Activity_Intro extends AppCompatActivity {

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);


        //해시키
        mContext = getApplicationContext();
        getHashKey(mContext);






        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //startActivity(intent);
                startActivity(new Intent(Activity_Intro.this, Activity_Login.class));
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0, 3000);
    }


    // 프로젝트의 해시키를 반환

    @Nullable
    public static String getHashKey(Context context) {

        final String TAG = "KeyHash";

        String keyHash = null;

        try {

            PackageInfo info =

                    context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);



            for (Signature signature : info.signatures) {

                MessageDigest md;

                md = MessageDigest.getInstance("SHA");

                md.update(signature.toByteArray());

                keyHash = new String(Base64.encode(md.digest(), 0));

                Log.d(TAG, keyHash);

            }

        } catch (Exception e) {

            Log.e("name not found", e.toString());

        }



        if (keyHash != null) {

            return keyHash;

        } else {

            return null;

        }

    }

}


