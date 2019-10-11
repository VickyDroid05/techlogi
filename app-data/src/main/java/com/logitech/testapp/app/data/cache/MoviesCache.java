package com.logitech.testapp.app.data.cache;

import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.data.model.MoviesEntity;

import java.util.Map;

/**
 * Created by Vigneshwaran G on 11/10/19.
 */
public interface MoviesCache {

    /**
     * Method to get the cached movies list
     *
     * @return The List of Movies in MoviesEntity obj
     */
    Map<Integer,MovieEntity> getMoviesMap();

    /**
     * Method to set the movies list in cache
     *
     * @param moviesEntity The MoviesEntity contains list of movies
     */
    void setMoviesList(Map<Integer,MovieEntity> moviesEntity);

    /**
     * Method to clear the cache
     */
    void clearCache();

}
