package com.example.movieproj.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_info")
public class MovieInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    Long movieId;
    @Column(name = "name")
    String movieName;
    @Column(name = "name_en")
    String movieEnglishName;
    @Column(name = "img")
    String movieImage;
    @Column(name = "big_image")
    String bigImage;
    @Column(name = "title_others")
    String titleOthers;
    @Column(name = "rating")
    Float rating;
    @Column(name = "rating_count")
    Integer ratingCount;
    @Column(name = "length")
    Integer length;
    @Column(name = "movie_publish_date")
    String moviePublishDate;
    @Column(name = "movie_year")
    String movieYear;
    @Column(name = "story")
    String story;
    @Column(name = "person_count")
    Integer personCount;
    @ManyToOne
    @JoinColumn(name = "director_id")
    DirectorInfo directorInfo;

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

    public DirectorInfo getDirectorInfo() {
        return directorInfo;
    }

    public void setDirectorInfo(DirectorInfo directorInfo) {
        this.directorInfo = directorInfo;
    }
}
