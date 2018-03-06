package com.example.td.testmvp.view;

import com.example.td.testmvp.model.Book;

/**
 * Created by td on 2018/3/6.
 */

public interface BookView {
    void loginData(Book s);
    void onError(String s);
}
