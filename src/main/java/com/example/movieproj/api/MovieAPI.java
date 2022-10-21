package com.example.movieproj.api;

import com.example.movieproj.repository.MovieInfoRepository;
import com.example.movieproj.repository.MovieRatingRepository;
import com.example.movieproj.repository.TypeInfoRepository;
import com.example.movieproj.service.MovieService;
import com.example.movieproj.service.dto.MovieDto;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class MovieAPI {
    @Resource
    MovieService movieService;
    @Resource
    TypeInfoRepository typeInfoRepository;
    @Resource
    MovieRatingRepository movieRatingRepository;
    @Resource
    MovieInfoRepository movieInfoRepository;
    @GetMapping("/movies")
    public ResponseEntity<SearchPage> getMovie(String keyword,
                                               @RequestParam(required = false,defaultValue = "0") Integer page,
                                               @RequestParam(required = false,defaultValue = "10") Integer size){
       return ResponseEntity.ok(movieService.searchMovie(keyword,page,size));
    }
    @GetMapping("/types")
    public ResponseEntity<SearchPage> getMovieTypes(String movieType,@RequestParam(required = false,defaultValue = "0") Integer page,
                                                    @RequestParam(required = false,defaultValue = "10") Integer size){
        return ResponseEntity.ok(movieService.searchMovieByType(movieType,page,size));
    }
    @PostMapping("/movies")
    public MovieDto publishMovie(@RequestBody MovieDto movieDto){
        return movieService.publishMovie(movieDto);
    }
    @DeleteMapping("/movies")
    public ResponseEntity deleteMovie(Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("删除成功");
    }
    @GetMapping("/movies/types")
    public ResponseEntity getAllTypes(){
        return ResponseEntity.ok(typeInfoRepository.findAll());
    }
    @GetMapping("/rating")
    public ResponseEntity getRating(String movieName){
        return ResponseEntity.ok(movieRatingRepository.findAllByMovieInfoMovieName(movieName));
    }
}
