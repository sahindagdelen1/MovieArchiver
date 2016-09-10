package com.saho.playground;

import com.saho.playground.models.Genre;
import com.saho.playground.models.Movie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sahin.dagdelen on 7/24/2016.
 * https://hello-angularjs.appspot.com/angularjs-restful-apis-post-method-code-example
 */

@RestController
public class RestServiceController {


    @Autowired
    private IMovieRepository repo;
    static final Logger logger= LogManager.getLogger(RestServiceController.class);



    @RequestMapping(value = "/movies/create",method = RequestMethod.POST)
    @ResponseBody
    public String createMovie(@RequestBody Movie movie){
          try{
            repo.save(movie);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return ex.getMessage();
        }
        String message= "{\"message\":\"Saved movie title " + movie.getTitle()+ ", year : " +movie.getYear()+ ", id: " + movie.getId() +"\"}";
        return message;


    }

    @RequestMapping("/movies/{id}")
    @ResponseBody
    public Movie readMovie(@PathVariable ("id")  Long id){
        Movie movie;
        try {
            movie=repo.findOne(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new Movie("NotFound",0);
        }


        if(movie==null){
            String errorMessage="no movie found for id "+id;
            logger.error(errorMessage);
            return new Movie("NotFound",0);
        }else {
            return movie;
        }
    }



    @RequestMapping("/movies/edit")
    @ResponseBody
    public Movie editMovie(@RequestBody Movie movie){
        if(movie==null){
            logger.error("No movie found");
            return new Movie("NotFound",0);
        }else {
            repo.save(movie);
            return movie;
        }
    }



    @RequestMapping("/movies")
    public List<Movie> readAllMovies(){
        List<Movie> movies= (List)repo.findAll();
         return movies;

    }


    @RequestMapping("/movies/delete/{id}")
    @ResponseBody
    public String deleteMovie(@PathVariable long id){
        try{
            repo.delete(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            return e.getMessage();
        }
       return  "{\"message\":\"Deleted movie id " +id +"\"}";
    }


  @RequestMapping("/movies/readAllBeforeYear")
    public List<Movie> getMoviesBeforeYear(@RequestParam(value ="year" )  int year){
        return  repo.findByYearLessThan(year);
    }

    @RequestMapping("/movies/readAllByYear")
    public List<Movie> getMoviesByYear(@RequestParam(value ="year" )  int year){
        return  repo.findByYear(year);
    }

    @RequestMapping("/movies/readAllByTitle")
    public  List<Movie> getMoviesByTitle(@RequestParam(value = "title") String title){
        return repo.findByTitleIgnoreCase(title);
    }


    @RequestMapping("/movies/readAllByRating")
    public  List<Movie> getMoviesByRating(@RequestParam(value = "rating") int rating){
        return repo.findByRating(rating);
    }


    @RequestMapping("/movies/readAllByRatingLessThan")
    public  List<Movie> getMoviesByRatingLessThan(@RequestParam(value = "rating") int rating){
        return repo.findByRatingLessThan(rating);
    }


    @RequestMapping("/movies/readAllByRatingMoreThan")
    public  List<Movie> getMoviesByRatingGreaterThan(@RequestParam(value = "rating") int rating){
        return repo.findByRatingGreaterThan(rating);
    }


    @RequestMapping("/movies/findByDirectorIgnoreCaseContaining")
    public  List<Movie> findByDirectorIgnoreCaseContaining(@RequestParam(value = "director") String director){
        return repo.findByDirectorIgnoreCaseContaining(director);
    }


    @RequestMapping("/movies/findByTitleIgnoreCaseContaining")
    public  List<Movie> findByTitleIgnoreCaseContaining(@RequestParam(value = "title") String title){
        return repo.findByTitleIgnoreCaseContaining(title);
    }
}
