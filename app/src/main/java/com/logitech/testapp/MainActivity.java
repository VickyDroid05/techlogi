package com.logitech.testapp;

import android.arch.lifecycle.ViewModelProviders;
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
import com.logitech.testapp.core.viewmodel.ViewModelFactory;
import com.logitech.testapp.viewmodel.MainActivityViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory mViewModelFactory;

    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((LogitechApplication)getApplication()).getMoviesComponent().inject(this);

        mMainActivityViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainActivityViewModel.class);

        mMainActivityViewModel.getMovies();
    }
}
