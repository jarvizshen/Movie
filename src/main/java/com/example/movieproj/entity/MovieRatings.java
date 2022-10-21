package com.example.movieproj.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_ratings")
public class MovieRatings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    float ratio;
    String ratingType;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    MovieInfo movieInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }
}
