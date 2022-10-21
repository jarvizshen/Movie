package com.example.movieproj.repository;

import com.example.movieproj.entity.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieInfoRepository extends JpaRepository<MovieInfo,Long> {
    MovieInfo findByMovieName(String movieName);
}
