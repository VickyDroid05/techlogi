package com.logitech.testapp.core.di;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

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
     * Method to provide application context instance
     *
     * @return Context
     */
    @Provides
    @Singleton
    Context providesApplication() {
        return application.getApplicationContext();
    }

    /**
     * Method to provide the Request queue for volley
     *
     * @param context The Context
     * @return The Request Queue
     */
    @Provides
    @Singleton
    public RequestQueue providesVolleyRequestQueue(Context context) {
        return Volley.newRequestQueue(context);
    }
}
