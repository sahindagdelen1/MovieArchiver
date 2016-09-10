package com.saho.playground;

import com.saho.playground.models.Genre;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sahin.dagdelen on 8/16/2016.
 */

@RestController
public class GenreServiceController {

    @Autowired
    private IMovieGenreRepository repo;

    static final Logger logger = LogManager.getLogger(GenreServiceController.class);


    @RequestMapping(value = "/moviegenres/create/{genre}", method = RequestMethod.POST)
    @ResponseBody
    public String createGenre(@PathVariable("genre") String genre) {
        Genre genreElement = new Genre(genre);
        try {
            repo.save(genreElement);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ex.getMessage();
        }
        String message = "{\"message\":\"Saved genre title " + genreElement.getGenreText() + ", id : " + genreElement.getId() + "\"}";
        return message;


    }

    @RequestMapping("/moviegenres/{id}")
    @ResponseBody
    public Genre readGenre(@PathVariable("id") Long id) {
        Genre genre;
        try {
            genre = repo.findOne(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new Genre(0, "NotFound");
        }


        if (genre == null) {
            String errorMessage = "no genre found for id " + id;
            logger.error(errorMessage);
            return new Genre(0, "NotFound");
        } else {
            return genre;
        }
    }


    @RequestMapping("/moviegenres/edit/{id}/{genreexp}")
    @ResponseBody
    public Genre editGenre(@PathVariable("id") Long id, @PathVariable("genreexp") String exp) {
        Genre genre;
        try {
            genre = repo.findOne(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new Genre("NotFound");
        }


        if (genre == null) {
            String errorMessage = "no movie found for id " + id;
            logger.error(errorMessage);
            return new Genre("NotFound");
        } else {
            genre.setGenreText(exp);
            repo.save(genre);
            return genre;
        }
    }


    @RequestMapping("/moviegenres")
    public List<Genre> readAllGenres() {
        List<Genre> movieGenres = (List) repo.findAll();
        return movieGenres;

    }


    @RequestMapping("/moviegenres/delete/{id}")
    @ResponseBody
    public String deleteMovieGenre(@PathVariable long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
        return "{\"message\":\"Deleted genre id " + id + "\"}";
    }
}
