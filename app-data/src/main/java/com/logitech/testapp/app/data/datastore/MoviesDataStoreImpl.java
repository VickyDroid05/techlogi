package com.logitech.testapp.app.data.datastore;

import com.logitech.testapp.app.data.cache.MoviesCache;
import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.data.model.MoviesEntity;
import com.logitech.testapp.app.data.network.MoviesApi;
import com.logitech.testapp.app.data.utils.MovieDataConstants;
import com.logitech.testapp.core.Failure;
import com.logitech.testapp.core.UseCaseCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 11/10/19.
 */
public class MoviesDataStoreImpl implements MoviesDataStore {

    private MoviesApi mMoviesApi;
    private MoviesCache mMoviesCache;

    @Inject
    public MoviesDataStoreImpl(MoviesApi moviesApi, MoviesCache moviesCache) {
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
            //If no data in cache check for network call to fetch the details
            mMoviesApi.getMoviesList(new UseCaseCallBack<MoviesEntity>() {
                @Override
                public void onSuccessCallBack(MoviesEntity moviesEntity) {
                    if (null != moviesEntity) {
                        // cache the movies list with movie id
                        cacheMoviesListWithId(moviesEntity);
                        // send back the movies list result
                        callBack.onSuccessCallBack(getMoviesListFromMap(mMoviesCache.getMoviesMap()));
                    } else {
                        // send back the error when no data found
                        callBack.onErrorCallBack(new Failure(MovieDataConstants.UNEXPECTED_FAILURE));
                    }
                }

                @Override
                public void onErrorCallBack(Failure error) {
                    // clear the cache on any error
                    mMoviesCache.clearCache();
                    callBack.onErrorCallBack(error);
                }
            });
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
