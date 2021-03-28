package com.example.homeservice.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("result")
    private Result result;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
}