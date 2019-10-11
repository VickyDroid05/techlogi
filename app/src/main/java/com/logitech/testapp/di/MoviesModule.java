package com.logitech.testapp.di;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.logitech.testapp.app.data.cache.MoviesCache;
import com.logitech.testapp.app.data.cache.MoviesCacheImpl;
import com.logitech.testapp.app.data.datastore.MoviesDataStore;
import com.logitech.testapp.app.data.datastore.MoviesDataStoreImpl;
import com.logitech.testapp.app.data.mapper.MoviesDataToDomainMapper;
import com.logitech.testapp.app.data.network.MoviesApi;
import com.logitech.testapp.app.domain.interactor.MovieDetailUseCase;
import com.logitech.testapp.app.domain.interactor.MovieDetailUseCaseImpl;
import com.logitech.testapp.app.domain.interactor.MoviesListUseCase;
import com.logitech.testapp.app.domain.interactor.MoviesListUseCaseImpl;
import com.logitech.testapp.app.domain.repository.MoviesRepository;
import com.logitech.testapp.app.repository.MoviesRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesModule {

    private final Application application;

    /**
     * Init the Movies module with the application instance
     *
     * @param application the LogitechApplication
     */
    public MoviesModule(Application application) {
        this.application = application;
    }

    /**
     * Method to provice application context instance s
     *
     * @return Context
     */
    @Provides
    @Singleton
    Context application() {
        return application.getApplicationContext();
    }

    /**
     * Method to provide the Request queue for volley
     *
     * @param context The Context
     * @return The Request Queue
     */
    @Provides
    @Singleton
    public RequestQueue providesVolleyRequestQueue(Context context) {
        return Volley.newRequestQueue(context);
    }

    /**
     * Method to provide Movies Api Instance
     *
     * @param requestQueue The Volley Request queue
     * @return MoviesApi
     */
    @Provides
    @Singleton
    public MoviesApi provideMoviesApi(RequestQueue requestQueue) {
        return new MoviesApi(requestQueue);
    }

    /**
     * Method to provide the MoviesCache Impl Instance
     *
     * @param moviesCache The MoviesCache Impl
     * @return The MoviesCache
     */
    @Provides
    @Singleton
    public MoviesCache providesMoviesCache(MoviesCacheImpl moviesCache) {
        return moviesCache;
    }

    /**
     * Method to provide MovieDataStore Instance
     *
     * @param moviesDataStoreImpl The MovieDataStore Impl
     * @return MovieDataStore
     */
    @Provides
    @Singleton
    public MoviesDataStore providesMovieDataStore(MoviesDataStoreImpl moviesDataStoreImpl) {
        return moviesDataStoreImpl;
    }

    /**
     * Method to provide the Data To Domain Mapper for Movies repo
     *
     * @return The MoviesDataToDomainMapper
     */
    @Provides
    @Singleton
    public MoviesDataToDomainMapper providesMovieDataToDomainMapper() {
        return new MoviesDataToDomainMapper();
    }

    /**
     * Method to provide Movie repository
     *
     * @param moviesRepository The Movie Repository Impl
     * @return The Movie Repository
     */
    @Provides
    @Singleton
    public MoviesRepository providesMovieRepository(MoviesRepositoryImpl moviesRepository) {
        return moviesRepository;
    }

    /**
     * Method to provide the UseCase for Movie List
     *
     * @param moviesListUseCase The Movies List UseCase
     * @return The UseCase
     */
    @Provides
    @Singleton
    public MoviesListUseCase providesMoviesListUseCase(MoviesListUseCaseImpl moviesListUseCase) {
        return moviesListUseCase;
    }

    /**
     * Method to provide the UseCase for Movie Detail
     *
     * @param movieDetailUseCase The Movies detail UseCase
     * @return The UseCase
     */
    @Provides
    @Singleton
    public MovieDetailUseCase providesMovieDetailUseCase(MovieDetailUseCaseImpl movieDetailUseCase) {
        return movieDetailUseCase;
    }

}
