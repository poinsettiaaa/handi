package com.example.handi.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    String SERVER_URI = "http://foodinside.webadsky.net/";

    // 로그인 mode=callLogin&m_id=admin&m_pwd=1234


    @POST("checkEmail.php")
    @FormUrlEncoded
    Call<Api_Base> callCheckEmail(@FieldMap Map<String, String> params);

    @POST("join.php")
    @FormUrlEncoded
    Call<Api_Login> callJoin(@FieldMap Map<String, String> params);

}
