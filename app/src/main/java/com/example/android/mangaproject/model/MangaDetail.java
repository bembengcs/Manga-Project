package com.example.android.mangaproject.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MangaDetail {

    @SerializedName("aka")
    @Expose
    private List<String> aka = null;
    @SerializedName("aka-alias")
    @Expose
    private List<String> akaAlias = null;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("artist_kw")
    @Expose
    private List<String> artistKw = null;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("author_kw")
    @Expose
    private List<String> authorKw = null;
    @SerializedName("autoManga")
    @Expose
    private boolean autoManga;
    @SerializedName("baka")
    @Expose
    private boolean baka;
    @SerializedName("categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("chapters")
    @Expose
    private List<List<Object>> chapters = null;
    @SerializedName("chapters_len")
    @Expose
    private int chaptersLen;
    @SerializedName("created")
    @Expose
    private double created;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("hits")
    @Expose
    private int hits;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("language")
    @Expose
    private int language;
    @SerializedName("last_chapter_date")
    @Expose
    private double lastChapterDate;
    @SerializedName("released")
    @Expose
    private int released;
    @SerializedName("startsWith")
    @Expose
    private String startsWith;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_kw")
    @Expose
    private List<String> titleKw = null;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("updatedKeywords")
    @Expose
    private boolean updatedKeywords;
    @SerializedName("url")
    @Expose
    private String url;

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public List<String> getAkaAlias() {
        return akaAlias;
    }

    public void setAkaAlias(List<String> akaAlias) {
        this.akaAlias = akaAlias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getArtistKw() {
        return artistKw;
    }

    public void setArtistKw(List<String> artistKw) {
        this.artistKw = artistKw;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getAuthorKw() {
        return authorKw;
    }

    public void setAuthorKw(List<String> authorKw) {
        this.authorKw = authorKw;
    }

    public boolean isAutoManga() {
        return autoManga;
    }

    public void setAutoManga(boolean autoManga) {
        this.autoManga = autoManga;
    }

    public boolean isBaka() {
        return baka;
    }

    public void setBaka(boolean baka) {
        this.baka = baka;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<List<Object>> getChapters() {
        return chapters;
    }

    public void setChapters(List<List<Object>> chapters) {
        this.chapters = chapters;
    }

    public int getChaptersLen() {
        return chaptersLen;
    }

    public void setChaptersLen(int chaptersLen) {
        this.chaptersLen = chaptersLen;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public double getLastChapterDate() {
        return lastChapterDate;
    }

    public void setLastChapterDate(double lastChapterDate) {
        this.lastChapterDate = lastChapterDate;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public void setStartsWith(String startsWith) {
        this.startsWith = startsWith;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTitleKw() {
        return titleKw;
    }

    public void setTitleKw(List<String> titleKw) {
        this.titleKw = titleKw;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isUpdatedKeywords() {
        return updatedKeywords;
    }

    public void setUpdatedKeywords(boolean updatedKeywords) {
        this.updatedKeywords = updatedKeywords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
