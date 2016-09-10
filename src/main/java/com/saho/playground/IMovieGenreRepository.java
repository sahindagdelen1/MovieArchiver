package com.saho.playground;

import com.saho.playground.models.Genre;
import com.saho.playground.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sahin.dagdelen on 7/24/2016.
 */
public interface IMovieGenreRepository extends CrudRepository<Genre,Long> {
 }
