package com.logitech.testapp.mapper;

import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.domain.model.Movie;
import com.logitech.testapp.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 13/10/19.
 */
public class MovieDomainToModelMapper {

    @Inject
    public MovieDomainToModelMapper() {
        //Default Constructor
    }

    /**
     * Method to convert the Movie list into movieModel list
     *
     * @param movies The Domain class of Movie
     * @return MovieModel class of Model type
     */
    public List<MovieModel> transform(List<Movie> movies) {
        List<MovieModel> moviesModel = new ArrayList<>();
        for (Movie movie : movies) {
            moviesModel.add(transform(movie));
        }
        return moviesModel;
    }

    /**
     * Method to convert the Movie into MovieModel
     *
     * @param movie The Movie class of data type
     * @return The MovieModel class of Model type
     */
    public MovieModel transform(Movie movie) {
        return new MovieModel(movie.getTitle(), movie.getYear(),
                movie.getRated(), movie.getReleased(), movie.getRuntime(),
                movie.getGenre(), movie.getDirector(), movie.getWriter(),
                movie.getActors(), movie.getPlot(), movie.getLanguage(),
                movie.getCountry(), movie.getAwards(), movie.getPoster());
    }
}
