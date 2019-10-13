package com.logitech.testapp;

import android.app.Application;

import com.logitech.testapp.core.di.ApplicationModule;
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
                .applicationModule(new ApplicationModule(this))
                .moviesModule(new MoviesModule())
                .build();
    }

    /**
     * Method to get the Movies Components
     *
     * @return Movies Components
     */
    public MoviesComponent getMoviesComponent() {
        return mMoviesComponent;
    }
}
