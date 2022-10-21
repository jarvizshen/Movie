package com.example.movieproj;

import com.alibaba.fastjson.JSONObject;
import com.example.movieproj.entity.MovieRatings;
import com.example.movieproj.repository.MovieDocumentRepository;
import com.example.movieproj.repository.MovieInfoRepository;
import com.example.movieproj.repository.MovieRatingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MovieProjApplicationTests {

    @Resource
    MovieDocumentRepository movieDocumentRepository;
    @Resource
    MovieRatingRepository movieRatingRepository;
    @Resource
    MovieInfoRepository movieInfoRepository;
    @Test
    void contextLoads() {
        List<MovieRatings> all = movieRatingRepository.findAllByMovieInfoMovieName("自杀小队");
    }

}
