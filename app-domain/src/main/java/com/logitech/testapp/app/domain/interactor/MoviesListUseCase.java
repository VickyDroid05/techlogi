package com.logitech.testapp.app.domain.interactor;

import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.core.callback.UseCaseCallBack;

import java.util.List;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public interface MoviesListUseCase {

    /**
     * Method to get the Movies List
     *
     * @param callBack callBack with movie list
     */
    void getMovies(UseCaseCallBack<List<Movie>> callBack);
}
