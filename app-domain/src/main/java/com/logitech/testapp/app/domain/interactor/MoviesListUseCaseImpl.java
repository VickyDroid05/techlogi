package com.logitech.testapp.app.domain.interactor;

import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.app.domain.repository.MoviesRepository;
import com.logitech.testapp.core.UseCaseCallBack;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public class MoviesListUseCaseImpl implements MoviesListUseCase {

    private MoviesRepository mMoviesRepository;

    @Inject
    public MoviesListUseCaseImpl(MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    /**
     * Method to get the Movies List
     *
     * @param callBack callBack with movie list
     */
    @Override
    public void getMovies(UseCaseCallBack<List<Movie>> callBack) {
        this.mMoviesRepository.getMoviesList(callBack);
    }
}
