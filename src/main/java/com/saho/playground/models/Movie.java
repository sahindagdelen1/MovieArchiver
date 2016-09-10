package com.saho.playground.models;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by sahin.dagdelen on 7/23/2016.
 *
 * http://christoph-burmeister.eu/?p=2849
 */

@Entity
@Table(name = "movie")
public class Movie implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Integer year;
    private  Integer rating;
    private String director;


    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre",joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_movieid")),inverseJoinColumns = @JoinColumn(name = "genre_id",referencedColumnName = "id"),foreignKey = @ForeignKey(name = "fk_genreid"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    @JsonProperty("genres")
    private List<Genre> genres;


    public Movie(){
      }


    public Movie(String title,int year){
        this.title=title;
        this.year=year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
