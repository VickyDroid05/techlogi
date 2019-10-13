package com.logitech.testapp.di;

import com.logitech.testapp.core.di.ApplicationModule;
import com.logitech.testapp.scenes.mainmenu.view.MainActivity;
import com.logitech.testapp.scenes.detail.view.MovieDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, MoviesModule.class, ViewModelModule.class})
public interface MoviesComponent {

    /**
     * Method to inject dependency
     *
     * @param activity The MainActivity
     */
    void inject(MainActivity activity);

    /**
     * Method to inject dependency
     *
     * @param activity The
     */
    void inject(MovieDetailActivity activity);
}
