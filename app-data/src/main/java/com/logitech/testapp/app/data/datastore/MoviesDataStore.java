package com.logitech.testapp.app.data.datastore;

import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.data.model.MoviesEntity;
import com.logitech.testapp.core.UseCaseCallBack;

import java.util.List;

/**
 * Created by Vigneshwaran G on 11/10/19.
 */
public interface MoviesDataStore {

    /**
     * Method to get the Movies list from dataStore
     *
     * @param callBack The CallBack
     */
    void getMoviesList(UseCaseCallBack<List<MovieEntity>> callBack);

    /**
     * Method to get the Movie detail based on the movie id
     * @param movieId The Movie Id
     * @param callBack The CallBack
     */
    void getMovieDetail(int movieId, UseCaseCallBack<MovieEntity> callBack);

}
