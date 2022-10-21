package com.example.movieproj.service.dto;

import com.example.movieproj.entity.ActorInfo;
import com.example.movieproj.entity.DirectorInfo;
import com.example.movieproj.entity.TypeInfo;

import java.util.List;

public class MovieDto {
    Long movieId;
    String movieName;
    String movieEnglishName;
    String movieImage;
    String bigImage;
    String titleOthers;
    Float rating;
    Integer ratingCount;
    Integer length;
    String moviePublishDate;
    String movieYear;
    String story;
    Integer personCount;
    DirectorInfo director;
    List<TypeInfo> movieTypes;
    List<ActorInfo> movieActors;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieEnglishName() {
        return movieEnglishName;
    }

    public void setMovieEnglishName(String movieEnglishName) {
        this.movieEnglishName = movieEnglishName;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getTitleOthers() {
        return titleOthers;
    }

    public void setTitleOthers(String titleOthers) {
        this.titleOthers = titleOthers;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getMoviePublishDate() {
        return moviePublishDate;
    }

    public void setMoviePublishDate(String moviePublishDate) {
        this.moviePublishDate = moviePublishDate;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public DirectorInfo getDirector() {
        return director;
    }

    public void setDirector(DirectorInfo director) {
        this.director = director;
    }

    public List<TypeInfo> getMovieTypes() {
        return movieTypes;
    }

    public void setMovieTypes(List<TypeInfo> movieTypes) {
        this.movieTypes = movieTypes;
    }

    public List<ActorInfo> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(List<ActorInfo> movieActors) {
        this.movieActors = movieActors;
    }
}
