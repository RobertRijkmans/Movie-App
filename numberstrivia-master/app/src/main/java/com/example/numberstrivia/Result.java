package com.example.numberstrivia;

import com.google.gson.annotations.SerializedName;

public class Result{
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("genre_ids")
    private int[] genre_ids;
    @SerializedName("id")
    private int id;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("popularity")
    private Number popularity;
    @SerializedName("vote_count")
    private int vote_count;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private Number vote_average;

    public Result(String poster_path, boolean adult, String overview, String release_date,
                  int[] genre_ids, int id, String original_title, String original_language,
                  String title, String backdrop_path, Number popularity, int vote_count,
                  boolean video, Number vote_average) {
        this.poster_path = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
    public boolean isAdult() {
        return adult;
    }
    public void setAdult(boolean adult) {
        this.adult = adult;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public int[] getGenre_ids() {
        return genre_ids;
    }
    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOriginal_title() {
        return original_title;
    }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
    public String getOriginal_language() {
        return original_language;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBackdrop_path() {
        return backdrop_path;
    }
    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
    public Number getPopularity() {
        return popularity;
    }
    public void setPopularity(Number popularity) {
        this.popularity = popularity;
    }
    public int getVote_count() {
        return vote_count;
    }
    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
    public boolean isVideo() {
        return video;
    }
    public void setVideo(boolean video) {
        this.video = video;
    }
    public Number getVote_average() {
        return vote_average;
    }
    public void setVote_average(Number vote_average) {
        this.vote_average = vote_average;
    }
}
