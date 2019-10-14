package com.logitech.testapp.app.data.datastore;

import android.util.Log;

import com.logitech.testapp.app.data.BuildConfig;
import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.core.callback.UseCaseCallBack;
import com.logitech.testapp.core.error.Failure;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Created by Vigneshwaran G on 15/10/19.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MoviesMockDataStoreImplTest {


    private static final String TAG = "MoviesDataStoreImplTest";

    @Mock
    private MoviesMockDataStoreImpl moviesMockDataStore;

    @Before
    public void setUp() {
        moviesMockDataStore = Mockito.mock(MoviesMockDataStoreImpl.class);
    }

    @Test
    public void testGetMovieList() {
        moviesMockDataStore.getMoviesList(new UseCaseCallBack<List<MovieEntity>>() {
            @Override
            public void onSuccessCallBack(List<MovieEntity> movieEntities) {
                Log.d(TAG, "onSuccessCallBack: " + movieEntities);
            }

            @Override
            public void onErrorCallBack(Failure error) {
                Log.d(TAG, "onErrorCallBack: " + error.getErrorCode());
            }
        });
    }

}