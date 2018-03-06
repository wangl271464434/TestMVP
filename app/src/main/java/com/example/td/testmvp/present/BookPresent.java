package com.example.td.testmvp.present;

import com.example.td.testmvp.model.Book;

/**
 * Created by td on 2018/3/6.
 */

public interface BookPresent {
    void login();
    void onSuccess(Book s);
    void onError(String s);
    void onDestroy();
}
