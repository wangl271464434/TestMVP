package com.example.td.testmvp.impl;

import android.util.Log;

import com.example.td.testmvp.data.TestApi;
import com.example.td.testmvp.model.Book;
import com.example.td.testmvp.model.RetrofitHelper;
import com.example.td.testmvp.present.BookPresent;
import com.example.td.testmvp.view.BookView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by td on 2018/3/6.
 */

public class BookPresentImpl implements BookPresent {
    private BookView bookView;
    public BookPresentImpl(BookView bookView) {
        this.bookView = bookView;
    }
    @Override
    public void login() {
        TestApi testApi = RetrofitHelper.getInstance().getServer().create(TestApi.class);
        Call<Book> call = testApi.getSearchBook("金瓶梅", null, 0, 1);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Log.i("success",response.body().toString());
                onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Log.i("fail",t.toString());
                onError(t.toString());
            }
        });
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.isEmpty() || pwd.isEmpty()){
                    onError("用户名或者密码不正确");
                }else{
                    onSuccess("登录成功");
                }
            }
        },3000);*/
    }

    @Override
    public void onDestroy() {
        bookView = null;
    }

    @Override
    public void onSuccess(Book book) {
        bookView.loginData(book);
    }
    @Override
    public void onError(String s) {
        bookView.onError(s);
    }
}
