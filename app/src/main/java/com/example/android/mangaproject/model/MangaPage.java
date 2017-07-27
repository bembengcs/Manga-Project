package com.example.android.mangaproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bembengcs on 7/26/2017.
 */

public class MangaPage {

    @SerializedName("images")
    @Expose
    private List<List<Object>> images = null;
    private String  BASE_URL = "https://cdn.mangaeden.com/mangasimg/";

    public List<List<Object>> getImages() {
        return images;
    }

    public void setImages(List<List<Object>> images) {
        this.images = images;
    }

}