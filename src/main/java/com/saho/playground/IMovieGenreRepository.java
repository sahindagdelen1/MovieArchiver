package com.saho.playground;

import com.saho.playground.models.Genre;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sahin.dagdelen on 7/24/2016.
 */
public interface IMovieGenreRepository extends CrudRepository<Genre, Long> {
}
