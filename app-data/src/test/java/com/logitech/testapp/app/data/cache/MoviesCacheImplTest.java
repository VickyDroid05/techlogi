package com.logitech.testapp.app.data.cache;

import com.logitech.testapp.app.data.BuildConfig;
import com.logitech.testapp.app.data.model.MovieEntity;

import org.apache.maven.model.Build;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Vigneshwaran G on 15/10/19.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MoviesCacheImplTest {

    @Mock
    private MoviesCacheImpl mMovieCache;


    @Before
    public void setUp(){
        mMovieCache = Mockito.mock(MoviesCacheImpl.class);

        mMovieCache.setMoviesList(constructTestData());
    }

    private Map<Integer, MovieEntity> constructTestData() {
        Map<Integer, MovieEntity> movies = new LinkedHashMap<>();
        movies.put(1,new MovieEntity());
        movies.put(2,new MovieEntity());
        movies.put(3,new MovieEntity());
        movies.put(4,new MovieEntity());
        return movies;
    }

    @Test
    public void getMoviesMap() {
        Map<Integer, MovieEntity> moviesMap = mMovieCache.getMoviesMap();
        Assert.assertNotNull(moviesMap);
    }

    @Test
    public void setMoviesList() {
        Map<Integer, MovieEntity> moviesMap = mMovieCache.getMoviesMap();
        Assert.assertNotNull(moviesMap);
    }

    @Test
    public void clearCache() {
        mMovieCache.clearCache();
        Map<Integer, MovieEntity> moviesMap = mMovieCache.getMoviesMap();
        Assert.assertNull(moviesMap.get(0));
    }
}