package com.logitech.testapp.scenes.mainmenu.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.logitech.testapp.LogitechApplication;
import com.logitech.testapp.R;
import com.logitech.testapp.core.error.Failure;
import com.logitech.testapp.core.view.BaseActivity;
import com.logitech.testapp.core.viewmodel.ViewModelFactory;
import com.logitech.testapp.model.MovieModel;
import com.logitech.testapp.scenes.detail.view.MovieDetailActivity;
import com.logitech.testapp.scenes.mainmenu.adapter.MovieListAdapter;
import com.logitech.testapp.scenes.mainmenu.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MovieListAdapter.MovieListClickListener {

    @Inject
    ViewModelFactory mViewModelFactory;

    private MainActivityViewModel mMainActivityViewModel;
    private MovieListAdapter mMovieListAdapter;

    /**
     * Method to get the activity view
     *
     * @return The Activity view
     */
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    /**
     * Method to initDagger components
     */
    @Override
    protected void initDaggerComponents() {
        ((LogitechApplication) getApplication()).getMoviesComponent().inject(this);
    }

    /**
     * Method to init ViewModel
     */
    @Override
    protected void initViewModel() {
        mMainActivityViewModel = ViewModelProviders.of(this, mViewModelFactory)
                .get(MainActivityViewModel.class);
    }

    /**
     * Method to load the data after view is created
     */
    @Override
    protected void initLoad() {
        mMainActivityViewModel.getMovies();
    }

    /**
     * Method to observer the observers of viewModel for results
     */
    @Override
    protected void initObservers() {
        this.mMainActivityViewModel.getMoviesLiveData().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(@Nullable List<MovieModel> movieModels) {
                if (null != mMovieListAdapter) {
                    mMovieListAdapter.updateList(movieModels);
                }
            }
        });

        this.mMainActivityViewModel.getErrorLiveData().observe(this, new Observer<Failure>() {
            @Override
            public void onChanged(@Nullable Failure failure) {
                if (failure != null) {
                    showErrorToast(failure.getErrorMessage());
                }
            }
        });

        this.mMainActivityViewModel.getLoadingProgressLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean show) {
                mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }


    //TODO : Can be removed onece binding is implemented
    private RecyclerView rvMovies;
    private ProgressBar mProgressBar;

    /**
     * Method to initialize views
     */
    @Override
    protected void initView() {
        rvMovies = findViewById(R.id.rv_movies);
        mProgressBar = findViewById(R.id.prg_bar);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        mMovieListAdapter = new MovieListAdapter(new ArrayList<MovieModel>());
        rvMovies.setAdapter(mMovieListAdapter);
        mMovieListAdapter.setMovieListClickListener(this);

    }

    /**
     * Method to init arguments that are sent from calling activity
     */
    @Override
    protected void initArguments() {
        //Do nothing
    }

    /**
     * Method interface implementation for item click of list view
     *
     * @param id the Movie Id
     */
    @Override
    public void onItemClicked(int id) {
        startActivity(MovieDetailActivity.getCallingIntent(this, id));
    }
}
