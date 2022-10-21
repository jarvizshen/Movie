package com.example.movieproj.service.dto;

import com.example.movieproj.entity.ActorInfo;
import com.example.movieproj.entity.DirectorInfo;
import com.example.movieproj.entity.MovieInfo;
import com.example.movieproj.entity.TypeInfo;
import com.example.movieproj.repository.ActorRepository;
import com.example.movieproj.repository.DirectorInfoRepository;
import com.example.movieproj.repository.TypeInfoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieMapper {
    public MovieInfo toEntity(MovieDto movieDto) {
        MovieInfo movieInfo = new MovieInfo();
        if (movieDto.getMovieId() != null) {
            movieInfo.setMovieId(movieDto.getMovieId());
        }
        movieInfo.setMovieImage(movieDto.getMovieImage());
        movieInfo.setMovieName(movieDto.getMovieName());
        movieInfo.setMovieEnglishName(movieDto.getMovieEnglishName());
        movieInfo.setMovieYear(movieDto.getMovieYear());
        movieInfo.setLength(movieDto.getLength());
        movieInfo.setBigImage(movieDto.getBigImage());
        movieInfo.setMoviePublishDate(movieDto.getMoviePublishDate());
        movieInfo.setPersonCount(movieDto.getPersonCount());
        movieInfo.setRating(movieDto.getRating());
        movieInfo.setRatingCount(movieDto.getRatingCount());
        movieInfo.setStory(movieDto.getStory());
        movieInfo.setMovieEnglishName(movieDto.getMovieName());
        movieInfo.setTitleOthers(movieDto.getTitleOthers());
        return movieInfo;
    }
}
