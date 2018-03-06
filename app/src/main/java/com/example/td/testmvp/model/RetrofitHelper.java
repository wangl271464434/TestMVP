package com.example.td.testmvp.model;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by td on 2018/3/6.
 */

public class RetrofitHelper {
    public static final String Base_URL = "https://api.douban.com/v2/";
    private static RetrofitHelper instance = null;
    Context context;
    OkHttpClient client = new OkHttpClient();
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    Retrofit retrofit = null;
    public static RetrofitHelper getInstance(){
        if (instance == null){
            instance = new RetrofitHelper();
        }
        return instance;
    }

    public RetrofitHelper() {
        init();
    }
    private void init() {
        retrofit = new Retrofit.Builder().baseUrl(Base_URL)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    }
    public Retrofit getServer(){
        return retrofit;
    }
}
