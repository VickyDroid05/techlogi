package com.logitech.testapp.app.domain.interactor;

import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.core.UseCaseCallBack;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public interface MovieDetailUseCase {

    /**
     * Method to get the Movie detail based on the id
     *
     * @param movieId  The Movie id
     * @param callBack The Callback
     */
    void getMovieDetail(int movieId, UseCaseCallBack<Movie> callBack);
}
