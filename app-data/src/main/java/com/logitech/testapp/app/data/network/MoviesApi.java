package com.logitech.testapp.app.data.network;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.logitech.testapp.app.data.model.MoviesEntity;
import com.logitech.testapp.core.error.Failure;
import com.logitech.testapp.core.callback.UseCaseCallBack;

import org.json.JSONObject;

import javax.inject.Inject;

public class MoviesApi {

    private static final String TAG = "MoviesApi";

    private RequestQueue mRequestQueue;

    @Inject
    public MoviesApi(RequestQueue requestQueue) {
        this.mRequestQueue = requestQueue;
    }

    public void getMoviesList(final UseCaseCallBack<MoviesEntity> callBack) {

        JsonObjectRequest moviesRequest = new JsonObjectRequest(MoviesNetworkConstants.MOVIES_ENDPOINT,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        MoviesEntity movies = new Gson().fromJson(response.toString(), MoviesEntity.class);
                        callBack.onSuccessCallBack(movies);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: "+error.getMessage() );
                callBack.onErrorCallBack(new Failure(error.getMessage()));
            }
        });

        //add this movies request to queue
        mRequestQueue.add(moviesRequest);
    }
}
