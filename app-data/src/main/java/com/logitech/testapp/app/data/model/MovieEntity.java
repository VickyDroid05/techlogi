package com.logitech.testapp.app.data.model;

import com.google.gson.annotations.SerializedName;

public class MovieEntity {

    @SerializedName("Title")
    private String mTitle;
    @SerializedName("Year")
    private String mYear;
    @SerializedName("Rated")
    private String mRated;
    @SerializedName("Released")
    private String mReleased;
    @SerializedName("Runtime")
    private String mRuntime;
    @SerializedName("Genre")
    private String mGenre;
    @SerializedName("Director")
    private String mDirector;
    @SerializedName("Writer")
    private String mWriter;
    @SerializedName("Actors")
    private String mActors;
    @SerializedName("Plot")
    private String mPlot;
    @SerializedName("Language")
    private String mLanguage;
    @SerializedName("Country")
    private String mCountry;
    @SerializedName("Awards")
    private String mAwards;

    public MovieEntity() {
        // Empty constructor
    }

    public String getTitle() {
        return mTitle;
    }

    public String getmYear() {
        return mYear;
    }

    public String getRated() {
        return mRated;
    }

    public String getReleased() {
        return mReleased;
    }

    public String getRuntime() {
        return mRuntime;
    }

    public String getGenre() {
        return mGenre;
    }

    public String getDirector() {
        return mDirector;
    }

    public String getWriter() {
        return mWriter;
    }

    public String getActors() {
        return mActors;
    }

    public String getPlot() {
        return mPlot;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getAwards() {
        return mAwards;
    }
}
