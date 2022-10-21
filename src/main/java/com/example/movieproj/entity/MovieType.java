package com.example.movieproj.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_types")
public class MovieType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long movieId;
    long typeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }
}
