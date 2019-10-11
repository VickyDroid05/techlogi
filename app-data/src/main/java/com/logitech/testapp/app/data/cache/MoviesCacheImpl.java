package com.logitech.testapp.app.data.cache;

import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.data.model.MoviesEntity;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 11/10/19.
 */
public class MoviesCacheImpl implements MoviesCache {

    private Map<Integer, MovieEntity> mMoviesMap;

    @Inject
    public MoviesCacheImpl() {
        // Default constructor
    }

    @Override
    public Map<Integer, MovieEntity> getMoviesMap() {
        return this.mMoviesMap;
    }

    @Override
    public void setMoviesList(Map<Integer, MovieEntity> moviesMap) {
        this.mMoviesMap = moviesMap;
    }

    @Override
    public void clearCache() {
        this.mMoviesMap.clear();
        this.mMoviesMap = null;
    }
}
