package com.logitech.testapp.di;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.logitech.testapp.app.data.network.MoviesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesModule {

    private final Application application;

    /**
     * Init the Movies module with the application instance
     *
     * @param application the LogitechApplication
     */
    public MoviesModule(Application application) {
        this.application = application;
    }

    /**
     * Method to provice application context instance s
     * @return Context
     */
    @Provides
    @Singleton
    Context application() {
        return application.getApplicationContext();
    }

    /**
     * Method to provide the Request queue for volley
     * @param context The Context
     * @return The Request Queue
     */
    @Provides
    @Singleton
    public RequestQueue providesVolleyRequestQueue(Context context){
        return Volley.newRequestQueue(context);
    }

    /**
     * Method to provide Movies Api Instance
     * @param requestQueue The Volley Request queue
     * @return MoviesApi
     */
    @Provides
    @Singleton
    public MoviesApi provideMoviesApi(RequestQueue requestQueue){
        return new MoviesApi(requestQueue);
    }

}
