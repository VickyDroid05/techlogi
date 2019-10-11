package com.logitech.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.logitech.testapp.app.data.datastore.MoviesDataStoreImpl;
import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.data.model.MoviesEntity;
import com.logitech.testapp.app.data.network.MoviesApi;
import com.logitech.testapp.app.domain.interactor.MoviesListUseCase;
import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.app.domain.repository.MoviesRepository;
import com.logitech.testapp.core.Failure;
import com.logitech.testapp.core.UseCaseCallBack;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTest";

    //TODO : for testing
    @Inject
    MoviesListUseCase mMoviesListUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((LogitechApplication)getApplication()).getMoviesComponent().inject(this);


        mMoviesListUseCase.getMovies(new UseCaseCallBack<List<Movie>>() {
            @Override
            public void onSuccessCallBack(List<Movie> moviesEntity) {
                Log.d(TAG, "onSuccessCallBack: "+moviesEntity.size());
            }

            @Override
            public void onErrorCallBack(Failure error) {
                Log.d(TAG, "onErrorCallBack: ");
            }
        });
    }
}
