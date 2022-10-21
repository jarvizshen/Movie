package com.example.movieproj.repository;

import com.example.movieproj.entity.MovieInfo;
import com.example.movieproj.entity.MovieRatings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRatingRepository extends JpaRepository<MovieRatings,Long> {
    List<MovieRatings> findAllByMovieInfoMovieName(String name);
}
