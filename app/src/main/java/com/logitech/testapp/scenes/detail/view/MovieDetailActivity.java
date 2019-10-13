package com.logitech.testapp.scenes.detail.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.logitech.testapp.LogitechApplication;
import com.logitech.testapp.R;
import com.logitech.testapp.core.error.Failure;
import com.logitech.testapp.core.view.BaseActivity;
import com.logitech.testapp.core.viewmodel.ViewModelFactory;
import com.logitech.testapp.databinding.ActivityMovieDetailBinding;
import com.logitech.testapp.model.KeyValueModel;
import com.logitech.testapp.model.MovieModel;
import com.logitech.testapp.scenes.detail.adapter.MovieDetailListAdapter;
import com.logitech.testapp.utils.MovieDetailBuilder;
import com.logitech.testapp.scenes.detail.viewmodel.MovieDetailViewModel;
import com.logitech.testapp.utils.MoviePresentationConstants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MovieDetailActivity extends BaseActivity {

    @Inject
    ViewModelFactory mViewModelFactory;

    private ActivityMovieDetailBinding mViewBinding;

    private MovieDetailViewModel mDetailViewModel;
    MovieDetailListAdapter mMovieDetailListAdapter;
    private int mMovieId;

    /**
     * Method to create intent for the current activity
     *
     * @param movieId The Movie Id
     * @return The Intent
     */
    public static Intent getCallingIntent(Context context, int movieId) {
        return new Intent(context, MovieDetailActivity.class)
                .putExtra(MoviePresentationConstants.BUNDLE_MOVIE_ID, movieId);
    }

    /**
     * Method to init the content view for the activity
     */
    @Override
    protected void initContentView() {
        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
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
        mDetailViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MovieDetailViewModel.class);
    }

    /**
     * Method to load the data after view is created
     */
    @Override
    protected void initLoad() {
        this.mDetailViewModel.getMovieDetail(mMovieId);
    }

    /**
     * Method to initialize views
     */
    @Override
    protected void initView() {
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        configureListView();

        mMovieDetailListAdapter = new MovieDetailListAdapter(new ArrayList<KeyValueModel>());
        mViewBinding.rvMovieDetail.setAdapter(mMovieDetailListAdapter);
    }

    /**
     * Method to observer the observers of viewModel for results
     */
    @Override
    protected void initObservers() {
        this.mDetailViewModel.getMovieLiveData().observe(this, new Observer<MovieModel>() {
            @Override
            public void onChanged(MovieModel movieModel) {

                updateBannerTitle(movieModel);

                List<KeyValueModel> detailKeyValue = MovieDetailBuilder.getDetailKeyValue(getApplicationContext(), movieModel);
                mMovieDetailListAdapter.updateList(detailKeyValue);
            }
        });

        this.mDetailViewModel.getErrorLiveData().observe(this, new Observer<Failure>() {
            @Override
            public void onChanged(@Nullable Failure failure) {
                if (failure != null) {
                    showErrorToast(failure.getErrorMessage());
                }
            }
        });
    }

    /**
     * Method to init arguments that are sent from calling activity
     */
    @Override
    protected void initArguments() {
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(MoviePresentationConstants.BUNDLE_MOVIE_ID)) {
            mMovieId = getIntent().getExtras().getInt(MoviePresentationConstants.BUNDLE_MOVIE_ID);
        }
    }

    /**
     * Method to configure the List view styling with decor view
     */
    private void configureListView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewBinding.rvMovieDetail.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mViewBinding.rvMovieDetail.getContext(),
                linearLayoutManager.getOrientation());
        mViewBinding.rvMovieDetail.addItemDecoration(dividerItemDecoration);
    }

    /**
     * Method to update the Banner , title and about banner in view
     *
     * @param movieModel The Movie Model
     */
    private void updateBannerTitle(MovieModel movieModel) {
        setTitle(movieModel.getTitle());
        mViewBinding.tvAbout.setText(getString(R.string.about_movie).concat(" : ").concat(movieModel.getTitle()));
        Glide.with(getApplicationContext())
                .load(!TextUtils.isEmpty(movieModel.getPoster()) ? movieModel.getPoster() : "")
                .apply(RequestOptions.placeholderOf(R.drawable.placeholder_small)
                        .error(R.drawable.placeholder_small))
                .into(mViewBinding.ivBanner);
    }

    /**
     * On Option Item selected for back press in toolbar
     *
     * @param item The Item selcted
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
