package com.logitech.testapp.app.repository;

import com.logitech.testapp.app.data.datastore.MoviesDataStore;
import com.logitech.testapp.app.data.mapper.MoviesDataToDomainMapper;
import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.app.domain.repository.MoviesRepository;
import com.logitech.testapp.core.Failure;
import com.logitech.testapp.core.UseCaseCallBack;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public class MoviesRepositoryImpl implements MoviesRepository {

    private MoviesDataToDomainMapper mMoviesDataToDomainMapper;
    private MoviesDataStore mMoviesDataStore;

    @Inject
    public MoviesRepositoryImpl(MoviesDataStore moviesDataStore,
                                MoviesDataToDomainMapper dataToDomainMapper) {
        this.mMoviesDataStore = moviesDataStore;
        this.mMoviesDataToDomainMapper = dataToDomainMapper;
    }

    /**
     * Method to get the Movies List
     *
     * @param callBack callBack with movie list
     */
    @Override
    public void getMoviesList(final UseCaseCallBack<List<Movie>> callBack) {
        this.mMoviesDataStore.getMoviesList(new UseCaseCallBack<List<MovieEntity>>() {
            @Override
            public void onSuccessCallBack(List<MovieEntity> movieEntities) {
                //Convert the data classe to domain class
                callBack.onSuccessCallBack(mMoviesDataToDomainMapper.transform(movieEntities));
            }

            @Override
            public void onErrorCallBack(Failure error) {
                callBack.onErrorCallBack(error);
            }
        });
    }

    /**
     * Method to get the Movie detail based on the id
     *
     * @param movieId  The Movie id
     * @param callBack The Callback
     */
    @Override
    public void getMovieDetails(int movieId, final UseCaseCallBack<Movie> callBack) {
        this.mMoviesDataStore.getMovieDetail(movieId, new UseCaseCallBack<MovieEntity>() {
            @Override
            public void onSuccessCallBack(MovieEntity movieEntity) {
                //Convert the data classe to domain class
                callBack.onSuccessCallBack(mMoviesDataToDomainMapper.transform(movieEntity));
            }

            @Override
            public void onErrorCallBack(Failure error) {
                callBack.onErrorCallBack(error);
            }
        });
    }
}
