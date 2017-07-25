package com.example.android.mangaproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bembengcs on 7/19/2017.
 */

public class Manga {

    // alias
    @SerializedName("a")
    @Expose
    private String a;

    // category
    @SerializedName("c")
    @Expose
    private List<String> c = null;

    // hits
    @SerializedName("h")
    @Expose
    private int h;

    // ID
    @SerializedName("i")
    @Expose
    private String i;

    // image
    @SerializedName("im")
    @Expose
    private String im;

    // last chapter date
    @SerializedName("ld")
    @Expose
    private int ld;

    // status
    @SerializedName("s")
    @Expose
    private int s;

    // title
    @SerializedName("t")
    @Expose
    private String t;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public List<String> getC() {
        return c;
    }

    public void setC(List<String> c) {
        this.c = c;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getIm() {
        final String MANGAROCK_POSTER_BASE_URL = "https://cdn.mangaeden.com/mangasimg/";
        return MANGAROCK_POSTER_BASE_URL + im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public int getLd() {
        return ld;
    }

    public void setLd(int ld) {
        this.ld = ld;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

}
