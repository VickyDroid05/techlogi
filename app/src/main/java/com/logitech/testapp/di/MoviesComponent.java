package com.logitech.testapp.di;

import com.logitech.testapp.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MoviesModule.class, ViewModelModule.class})
public interface MoviesComponent {

    /**
     * Method to inject dependency
     *
     * @param activity The MainActivity
     */
    void inject(MainActivity activity);
}
