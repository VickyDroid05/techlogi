package com.logitech.testapp.app.data.datastore;

import android.content.Context;

import com.google.gson.Gson;
import com.logitech.testapp.app.data.cache.MoviesCache;
import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.data.model.MoviesEntity;
import com.logitech.testapp.app.data.network.MoviesApi;
import com.logitech.testapp.app.data.utils.MovieDataConstants;
import com.logitech.testapp.core.error.Failure;
import com.logitech.testapp.core.callback.UseCaseCallBack;
import com.logitech.testapp.core.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 11/10/19.
 */
public class MoviesMockDataStoreImpl implements MoviesDataStore {

    private MoviesApi mMoviesApi;
    private MoviesCache mMoviesCache;
    private Context mContext;

    @Inject
    public MoviesMockDataStoreImpl(Context context, MoviesApi moviesApi, MoviesCache moviesCache) {
        this.mContext = context;
        this.mMoviesApi = moviesApi;
        this.mMoviesCache = moviesCache;
    }

    /**
     * Method to get the Movies list from dataStore
     *
     * @param callBack The CallBack
     */
    @Override
    public void getMoviesList(final UseCaseCallBack<List<MovieEntity>> callBack) {
        if (null != mMoviesCache.getMoviesMap() && !mMoviesCache.getMoviesMap().isEmpty()) {
            //retrieve the movies list from cache, as it is already present in the cache
            callBack.onSuccessCallBack(getMoviesListFromMap(mMoviesCache.getMoviesMap()));
        } else {
            //THIS IS A CACHE IMPLEMENTATION

            String moviesJson = FileUtils.loadJSONFromAsset(mContext, MovieDataConstants.MOVIES_JSON_FILE);
            MoviesEntity moviesEntity = new Gson().fromJson(moviesJson,MoviesEntity.class);
            // cache the movies list with movie id
            cacheMoviesListWithId(moviesEntity);
            // send back the movies list result
            callBack.onSuccessCallBack(getMoviesListFromMap(mMoviesCache.getMoviesMap()));
        }
    }

    /**
     * Method to get the Movie detail based on the movie id
     *
     * @param movieId  The Movie Id
     * @param callBack The CallBack
     */
    @Override
    public void getMovieDetail(int movieId, UseCaseCallBack<MovieEntity> callBack) {
        if (null != mMoviesCache.getMoviesMap()
                && !mMoviesCache.getMoviesMap().isEmpty()
                && mMoviesCache.getMoviesMap().containsKey(movieId)) {
            //If movies Map contains the movies list and movieId, send the result back
            callBack.onSuccessCallBack(mMoviesCache.getMoviesMap().get(movieId));
        } else {
            //If Movies id not found send back the failure
            callBack.onErrorCallBack(new Failure(MovieDataConstants.NO_DATA_FOUND));
        }
    }

    /**
     * Method to get the list of Movies object from the map
     *
     * @param moviesMap The Movies Map
     * @return List<MovieEntity>
     */
    private List<MovieEntity> getMoviesListFromMap(Map<Integer, MovieEntity> moviesMap) {
        return new ArrayList<>(moviesMap.values());
    }

    /**
     * Method to cache the list of movies with movie id as Key and Movie Objects as value
     * Using this key Id , Movies are fetched
     *
     * @param moviesEntity The MoviesEntity
     */
    private void cacheMoviesListWithId(MoviesEntity moviesEntity) {
        Map<Integer, MovieEntity> moviesMap = new HashMap<>();
        for (int id = 0; id < moviesEntity.getMoviesList().size(); id++) {
            moviesMap.put(id, moviesEntity.getMoviesList().get(id));
        }
        mMoviesCache.setMoviesList(moviesMap);
    }
}
