package com.logitech.testapp.app.domain.repository;

import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.core.UseCaseCallBack;

import java.util.List;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public interface MoviesRepository {

    /**
     * Method to get the Movies List
     *
     * @param caseCallBack callBack with movie list
     */
    void getMoviesList(UseCaseCallBack<List<Movie>> caseCallBack);

    /**
     * Method to get the Movie detail based on the id
     *
     * @param movieId  The Movie id
     * @param callBack The Callback
     */
    void getMovieDetails(int movieId, UseCaseCallBack<Movie> callBack);
}
