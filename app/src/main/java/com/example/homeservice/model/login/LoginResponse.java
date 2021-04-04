package com.example.homeservice.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("result")
    private LoginResult loginResult;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public void setLoginResult(LoginResult loginResult) {
        this.loginResult = loginResult;
    }

    public LoginResult getLoginResult() {
        return loginResult;
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