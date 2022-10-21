package com.example.movieproj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(indexName = "mtime_movie")
public class MovieDocument {
    @Id
    Long movie_id;
    @Field(type = FieldType.Keyword)
    String name;
    @Field(type = FieldType.Keyword)
    String name_en;
    @Field(type = FieldType.Keyword)
    String img;
    @Field(type = FieldType.Keyword)
    String big_image;
    @Field(type = FieldType.Keyword)
    String title_others;
    @Field(type = FieldType.Float)
    Float rating;
    @Field(type = FieldType.Integer)
    Integer rating_count;
    @Field(type = FieldType.Integer)
    Integer length;
    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute, pattern = "yyyy-MM- dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = " GMT+8")
    String movie_publish_date;
    @Field(type = FieldType.Keyword)
    String movie_year;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    String story;
    @Field(type = FieldType.Integer)
    Integer person_count;
    @Field(type = FieldType.Object)
    Object movie_type;
    @Field(type = FieldType.Object)
    Object actors;
    @Field(type = FieldType.Object)
    Object director;

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBig_image() {
        return big_image;
    }

    public void setBig_image(String big_image) {
        this.big_image = big_image;
    }

    public String getTitle_others() {
        return title_others;
    }

    public void setTitle_others(String title_others) {
        this.title_others = title_others;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getRating_count() {
        return rating_count;
    }

    public void setRating_count(Integer rating_count) {
        this.rating_count = rating_count;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getMovie_publish_date() {
        return movie_publish_date;
    }

    public void setMovie_publish_date(String movie_publish_date) {
        this.movie_publish_date = movie_publish_date;
    }

    public String getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(String movie_year) {
        this.movie_year = movie_year;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Integer getPerson_count() {
        return person_count;
    }

    public void setPerson_count(Integer person_count) {
        this.person_count = person_count;
    }

    public Object getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(Object movie_type) {
        this.movie_type = movie_type;
    }

    public Object getActors() {
        return actors;
    }

    public void setActors(Object actors) {
        this.actors = actors;
    }

    public Object getDirector() {
        return director;
    }

    public void setDirector(Object director) {
        this.director = director;
    }
}
