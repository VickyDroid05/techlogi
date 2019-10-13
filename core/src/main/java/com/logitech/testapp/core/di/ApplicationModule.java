package com.logitech.testapp.core.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vigneshwaran G on 14/10/19.
 */
@Module
public class ApplicationModule {

    private final Application application;

    /**
     * Init the Application module with the application instance
     *
     * @param application the LogitechApplication
     */
    public ApplicationModule(Application application) {
        this.application = application;
    }

    /**
     * Method to provice application context instance
     *
     * @return Context
     */
    @Provides
    @Singleton
    Context application() {
        return application.getApplicationContext();
    }
}
