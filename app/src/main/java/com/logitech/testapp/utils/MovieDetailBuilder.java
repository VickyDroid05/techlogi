package com.logitech.testapp.utils;

import android.content.Context;
import android.text.TextUtils;

import com.logitech.testapp.R;
import com.logitech.testapp.model.KeyValueModel;
import com.logitech.testapp.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vigneshwaran G on 13/10/19.
 */
public class MovieDetailBuilder {

    private MovieDetailBuilder() {
        //Private constructor
    }

    /**
     * Method to construct list of title and description
     *
     * @param context    The Context
     * @param movieModel The MovieModel
     * @return The list of key and value model
     */
    public static List<KeyValueModel> getDetailKeyValue(Context context, MovieModel movieModel) {
        List<KeyValueModel> valueModels = new ArrayList<>();
        if (!TextUtils.isEmpty(movieModel.getGenre())) {
            valueModels.add(transform(movieModel.getGenre(), context.getString(R.string.genre)));
        }
        if (!TextUtils.isEmpty(movieModel.getLanguage())) {
            valueModels.add(transform(movieModel.getLanguage(), context.getString(R.string.language)));
        }
        if (!TextUtils.isEmpty(movieModel.getActors())) {
            valueModels.add(transform(movieModel.getActors(), context.getString(R.string.actors)));
        }
        if (!TextUtils.isEmpty(movieModel.getAwards())) {
            valueModels.add(transform(movieModel.getAwards(), context.getString(R.string.awards)));
        }
        if (!TextUtils.isEmpty(movieModel.getCountry())) {
            valueModels.add(transform(movieModel.getCountry(), context.getString(R.string.country)));
        }
        if (!TextUtils.isEmpty(movieModel.getDirector())) {
            valueModels.add(transform(movieModel.getDirector(), context.getString(R.string.director)));
        }
        if (!TextUtils.isEmpty(movieModel.getPlot())) {
            valueModels.add(transform(movieModel.getPlot(), context.getString(R.string.plot)));
        }
        if (!TextUtils.isEmpty(movieModel.getRated())) {
            valueModels.add(transform(movieModel.getRated(), context.getString(R.string.rated)));
        }
        if (!TextUtils.isEmpty(movieModel.getReleased())) {
            valueModels.add(transform(movieModel.getReleased(), context.getString(R.string.released)));
        }
        if (!TextUtils.isEmpty(movieModel.getRuntime())) {
            valueModels.add(transform(movieModel.getRuntime(), context.getString(R.string.runtime)));
        }
        if (!TextUtils.isEmpty(movieModel.getWriter())) {
            valueModels.add(transform(movieModel.getWriter(), context.getString(R.string.writer)));
        }
        if (!TextUtils.isEmpty(movieModel.getYear())) {
            valueModels.add(transform(movieModel.getYear(), context.getString(R.string.year)));
        }
        return valueModels;
    }


    /**
     * Method to convert the KeyValueModel
     *
     * @param title       the title
     * @param description The Description
     * @return The KeyValue Model
     */
    private static KeyValueModel transform(String title, String description) {
        return new KeyValueModel(title, description);
    }


}
