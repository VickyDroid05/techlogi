package com.logitech.testapp.app.domain.interactor;

import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.app.domain.repository.MoviesRepository;
import com.logitech.testapp.core.UseCaseCallBack;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public class MovieDetailUseCaseImpl implements MovieDetailUseCase {

    private MoviesRepository mMovieRepository;

    public MovieDetailUseCaseImpl(MoviesRepository moviesRepository) {
        this.mMovieRepository = moviesRepository;
    }

    /**
     * Method to get the Movie detail based on the id
     *
     * @param movieId  The Movie id
     * @param callBack The Callback
     */
    @Override
    public void getMovieDetail(int movieId, UseCaseCallBack<Movie> callBack) {
        this.mMovieRepository.getMovieDetails(movieId, callBack);
    }
}
