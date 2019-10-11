package com.logitech.testapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.logitech.testapp.app.domain.interactor.MoviesListUseCase;
import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.core.Failure;
import com.logitech.testapp.core.UseCaseCallBack;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "MainActivityViewModel";
    private MoviesListUseCase mMovieListUseCase;

    @Inject
    public MainActivityViewModel(MoviesListUseCase moviesListUseCase) {
        this.mMovieListUseCase = moviesListUseCase;
    }

    public void getMovies() {
        mMovieListUseCase.getMovies(new UseCaseCallBack<List<Movie>>() {
            @Override
            public void onSuccessCallBack(List<Movie> moviesEntity) {
                Log.d(TAG, "onSuccessCallBack: " + moviesEntity.size());
            }

            @Override
            public void onErrorCallBack(Failure error) {
                Log.d(TAG, "onErrorCallBack: ");
            }
        });
    }

}
