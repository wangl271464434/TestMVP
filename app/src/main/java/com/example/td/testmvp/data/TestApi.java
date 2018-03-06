package com.example.td.testmvp.data;

import com.example.td.testmvp.model.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by td on 2018/3/6.
 */

public interface TestApi {
    @GET("book/search")
    Call<Book> getSearchBook(@Query("q") String name, @Query("tag") String tag, @Query("start") int start, @Query("count") int count);
}
