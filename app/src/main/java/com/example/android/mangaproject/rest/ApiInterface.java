package com.example.android.mangaproject.rest;

import com.example.android.mangaproject.model.MangaDetail;
import com.example.android.mangaproject.model.MangaPage;
import com.example.android.mangaproject.model.MangasResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by bembengcs on 7/19/2017.
 */

public interface ApiInterface {
    @GET("api/list/0")
    Call<MangasResponse> getManga(@Query("p") int page, @Query("l") int limit);

    @GET("api/manga/{i}")
    Call<MangaDetail> getMangaDetail(@Path("i") String i);

    @GET("api/chapter/{o}")
    Call<MangaPage> getPageImage(@Path("o") String o);

}
