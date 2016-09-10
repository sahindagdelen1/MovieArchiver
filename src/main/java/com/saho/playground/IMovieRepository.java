package com.saho.playground;

import com.saho.playground.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sahin.dagdelen on 7/24/2016.
 * <p/>
 * http://docs.spring.io/spring-data/jpa/docs/1.5.1.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 */
public interface IMovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByYearLessThan(int year);

    List<Movie> findByTitleIgnoreCase(String title);

    List<Movie> findByYear(int year);

    List<Movie> findByDirectorIgnoreCase(String director);

    List<Movie> findByRating(int rating);

    List<Movie> findByRatingLessThan(int rating);

    List<Movie> findByRatingGreaterThan(int rating);

    List<Movie> findByDirectorIgnoreCaseContaining(String director);

    List<Movie> findByTitleIgnoreCaseContaining(String title);
}
