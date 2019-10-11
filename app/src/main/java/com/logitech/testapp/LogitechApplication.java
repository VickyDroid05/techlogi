package com.logitech.testapp;

import android.app.Application;

import com.logitech.testapp.di.DaggerMoviesComponent;
import com.logitech.testapp.di.MoviesComponent;
import com.logitech.testapp.di.MoviesModule;

public class LogitechApplication extends Application {

    private MoviesComponent mMoviesComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //initialize the Dagger components
        initDaggerComponents();
    }

    /**
     * Method to create dagger componenets
     */
    private void initDaggerComponents() {
        mMoviesComponent = DaggerMoviesComponent.builder()
                .moviesModule(new MoviesModule(this))
                .build();
    }

    /**
     * Method to get the Movies Components
     * @return Movies Components
     */
    public MoviesComponent getMoviesComponent() {
        return mMoviesComponent;
    }
}
