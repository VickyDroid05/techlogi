package com.logitech.testapp.app.data.mapper;

import com.logitech.testapp.app.data.model.MovieEntity;
import com.logitech.testapp.app.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vigneshwaran G on 12/10/19.
 */
public class MoviesDataToDomainMapper {

    @Inject
    public MoviesDataToDomainMapper() {
        //Default Constructor
    }

    /**
     * Method to convert the MovieEntity list into movie list
     *
     * @param movieEntities The Entity class of Movie
     * @return Movie class of domain type
     */
    public List<Movie> transform(List<MovieEntity> movieEntities) {
        List<Movie> movies = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntities) {
            movies.add(transform(movieEntity));
        }
        return movies;
    }

    /**
     * Method to convert the MovieEntity into Movie
     *
     * @param movieEntity The MovieEntity class of data type
     * @return The Movie class of domain type
     */
    public Movie transform(MovieEntity movieEntity) {
        return new Movie(movieEntity.getTitle(), movieEntity.getYear(),
                movieEntity.getRated(), movieEntity.getReleased(), movieEntity.getRuntime(),
                movieEntity.getGenre(), movieEntity.getDirector(), movieEntity.getWriter(),
                movieEntity.getActors(), movieEntity.getPlot(), movieEntity.getLanguage(),
                movieEntity.getCountry(), movieEntity.getAwards());
    }


}
