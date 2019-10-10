package com.logitech.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.logitech.testapp.app.data.model.MoviesEntity;
import com.logitech.testapp.app.data.network.MoviesApi;
import com.logitech.testapp.core.Failure;
import com.logitech.testapp.core.UseCaseCallBack;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTest";

    @Inject
    MoviesApi moviesApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((LogitechApplication)getApplication()).getMoviesComponent().inject(this);


        moviesApi.getMoviesList(new UseCaseCallBack<MoviesEntity>() {
            @Override
            public void onSuccessCallBack(MoviesEntity moviesEntity) {
                Log.d(TAG, "onSuccessCallBack: ");
            }

            @Override
            public void onErrorCallBack(Failure error) {
                Log.d(TAG, "onErrorCallBack: ");
            }
        });
    }
}
