package com.example.android.mangaproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bembengcs on 7/19/2017.
 */

public class MangasResponse {
    @SerializedName("end")
    @Expose
    private int end;
    @SerializedName("manga")
    @Expose
    private List<Manga> manga = null;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("start")
    @Expose
    private int start;
    @SerializedName("total")
    @Expose
    private int total;

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<Manga> getManga() {
        return manga;
    }

    public void setManga(List<Manga> manga) {
        this.manga = manga;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
