package com.example.handi.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api_Login {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("idx")
    @Expose
    private String strIdx;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStrIdx() {
        return strIdx;
    }

    public void setStrIdx(String strIdx) {
        this.strIdx = strIdx;
    }
}
