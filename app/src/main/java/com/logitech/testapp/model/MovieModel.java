package com.logitech.testapp.model;

/**
 * Created by Vigneshwaran G on 13/10/19.
 */
public class MovieModel {

    private String mTitle;
    private String mYear;
    private String mRated;
    private String mReleased;
    private String mRuntime;
    private String mGenre;
    private String mDirector;
    private String mWriter;
    private String mActors;
    private String mPlot;
    private String mLanguage;
    private String mCountry;
    private String mAwards;
    private String mPoster;

    public MovieModel(String mTitle, String mYear, String mRated,
                      String mReleased, String mRuntime, String mGenre,
                      String mDirector, String mWriter, String mActors,
                      String mPlot, String mLanguage, String mCountry,
                      String mAwards, String mPoster) {
        this.mTitle = mTitle;
        this.mYear = mYear;
        this.mRated = mRated;
        this.mReleased = mReleased;
        this.mRuntime = mRuntime;
        this.mGenre = mGenre;
        this.mDirector = mDirector;
        this.mWriter = mWriter;
        this.mActors = mActors;
        this.mPlot = mPlot;
        this.mLanguage = mLanguage;
        this.mCountry = mCountry;
        this.mAwards = mAwards;
        this.mPoster = mPoster;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getYear() {
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

    public String getPoster() {
        return mPoster;
    }

}
