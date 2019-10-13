package com.logitech.testapp.scenes.mainmenu.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.logitech.testapp.app.domain.interactor.MoviesListUseCase;
import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.core.error.Failure;
import com.logitech.testapp.core.callback.UseCaseCallBack;
import com.logitech.testapp.mapper.MovieDomainToModelMapper;
import com.logitech.testapp.model.MovieModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "MainActivityViewModel";
    private MoviesListUseCase mMovieListUseCase;
    private MovieDomainToModelMapper mDomainToModelMapper;
    private MutableLiveData<Boolean> mLoadingProgressLiveData = new MutableLiveData<>();
    private MutableLiveData<List<MovieModel>> mMoviesLiveData = new MutableLiveData<>();
    private MutableLiveData<Failure> mErrorLiveData = new MutableLiveData<>();

    @Inject
    public MainActivityViewModel(MoviesListUseCase moviesListUseCase,
                                 MovieDomainToModelMapper domainToModelMapper) {
        this.mMovieListUseCase = moviesListUseCase;
        this.mDomainToModelMapper = domainToModelMapper;
    }

    /**
     * Method to get the list of movies
     */
    public void getMovies() {
        mLoadingProgressLiveData.postValue(true);
        mMovieListUseCase.getMovies(new UseCaseCallBack<List<Movie>>() {
            @Override
            public void onSuccessCallBack(List<Movie> movies) {
                Log.d(TAG, "onSuccessCallBack: " + movies.size());
                mLoadingProgressLiveData.postValue(false);
                mMoviesLiveData.postValue(mDomainToModelMapper.transform(movies));
            }

            @Override
            public void onErrorCallBack(Failure error) {
                Log.d(TAG, "onErrorCallBack: ");
                mLoadingProgressLiveData.postValue(false);
                mErrorLiveData.postValue(error);
            }
        });
    }

    /**
     * Method to get the Loading Progress Status
     *
     * @return MutableLiveData<Boolean>
     */
    public MutableLiveData<Boolean> getLoadingProgressLiveData() {
        return this.mLoadingProgressLiveData;
    }

    /**
     * Method to get the Movies Live Data
     *
     * @return List of Movie Model
     */
    public MutableLiveData<List<MovieModel>> getMoviesLiveData() {
        return this.mMoviesLiveData;
    }

    /**
     * Method to get the Error live data
     *
     * @return MutableLiveData<Failure>
     */
    public MutableLiveData<Failure> getErrorLiveData() {
        return this.mErrorLiveData;
    }
}
