package com.logitech.testapp.app.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesEntity {

    @SerializedName("movies")
    List<MovieEntity> mMoviesList;

    public List<MovieEntity> getMoviesList() {
        return mMoviesList;
    }
}
