package com.logitech.testapp.scenes.detail.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.logitech.testapp.app.domain.interactor.MovieDetailUseCase;
import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.core.error.Failure;
import com.logitech.testapp.core.callback.UseCaseCallBack;
import com.logitech.testapp.mapper.MovieDomainToModelMapper;
import com.logitech.testapp.model.MovieModel;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 13/10/19.
 */
public class MovieDetailViewModel extends ViewModel {
    private static final String TAG = "MovieDetailViewModel";

    private MovieDetailUseCase mMovieDetailUseCase;
    private MovieDomainToModelMapper mDomainToModelMapper;
    private MutableLiveData<MovieModel> mMovieLiveData = new MutableLiveData<>();
    private MutableLiveData<Failure> mErrorLiveData = new MutableLiveData<>();

    @Inject
    public MovieDetailViewModel(MovieDetailUseCase mMovieDetailUseCase,
                                MovieDomainToModelMapper domainToModelMapper) {
        this.mMovieDetailUseCase = mMovieDetailUseCase;
        this.mDomainToModelMapper = domainToModelMapper;
    }

    /**
     * Method to get the movie details
     *
     * @param movieId The Movie Id
     */
    public void getMovieDetail(int movieId) {
        mMovieDetailUseCase.getMovieDetail(movieId, new UseCaseCallBack<Movie>() {
            @Override
            public void onSuccessCallBack(Movie movie) {
                Log.d(TAG, "onSuccessCallBack: " + movie.getTitle());
                mMovieLiveData.postValue(mDomainToModelMapper.transform(movie));
            }

            @Override
            public void onErrorCallBack(Failure error) {
                Log.d(TAG, "onErrorCallBack: " + error.getErrorCode());
                mErrorLiveData.postValue(error);
            }
        });
    }

    /**
     * Method to get the Movie Live Data
     *
     * @return MutableLiveData<MovieModel>
     */
    public MutableLiveData<MovieModel> getMovieLiveData() {
        return mMovieLiveData;
    }

    /**
     * Method to get the failure Live data
     *
     * @return MutableLiveData<Failure>
     */
    public MutableLiveData<Failure> getErrorLiveData() {
        return mErrorLiveData;
    }
}
