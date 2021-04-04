package com.example.homeservice.helper;

import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.example.homeservice.BaseUrl;
import com.example.homeservice.HttpsTrustManager;
import com.example.homeservice.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Retrofit instance
public class RetrofitInstance {
    public static Retrofit getInstance(Context context) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new ChuckerInterceptor(context))
                .build();

        Gson gson = new GsonBuilder().serializeNulls().create();

        return new Retrofit.Builder()
                .baseUrl(BaseUrl.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }
}
