package com.example.movieproj.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.movieproj.entity.*;
import com.example.movieproj.repository.*;
import com.example.movieproj.service.dto.MovieDto;
import com.example.movieproj.service.MovieService;
import com.example.movieproj.service.dto.MovieMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rabbitmq.tools.json.JSONUtil;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.json.Json;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDocumentRepository movieDocumentRepository;
    @Resource
    DirectorInfoRepository directorInfoRepository;
    @Resource
    MovieInfoRepository movieInfoRepository;
    @Resource
    JdbcTemplate jdbcTemplate;
    @Resource
    ActorRepository actorRepository;
    @Resource
    TypeInfoRepository typeInfoRepository;
    @Resource
    MovieMapper movieMapper;
    @Resource
    RabbitTemplate rabbitTemplate;

    public MovieServiceImpl(MovieDocumentRepository movieDocumentRepository) {
        this.movieDocumentRepository = movieDocumentRepository;
    }

    @Override
    public SearchPage<MovieDocument> searchMovie(String keyword,@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size) {
        SearchPage<MovieDocument> documents;
        if (keyword == null || keyword.length() == 0) {
            documents = this.movieDocumentRepository.searchAll(PageRequest.of(page, size));
        } else {
            documents = this.movieDocumentRepository.searchMovie(keyword,PageRequest.of(page, size));
        }
        return documents;
    }

    @Override
    public SearchPage<MovieDocument> searchMovieByType(String movieType,@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size) {
        return movieDocumentRepository.findByMovieType(movieType,PageRequest.of(page, size));
    }

    @Override
    public MovieDto publishMovie(MovieDto movieDto) {
        MovieInfo movieInfo = movieMapper.toEntity(movieDto);
        if (movieDto.getDirector() != null) {
            DirectorInfo director = movieDto.getDirector();
            if (director.getDirectorId() == null) {
                director.setDirectorId(System.currentTimeMillis());
                director = directorInfoRepository.save(director);
            }
            movieInfo.setDirectorInfo(director);
        }
        if (movieDto.getMovieActors() != null) {
            List<ActorInfo> actors = movieDto.getMovieActors();
            for (ActorInfo actor : actors) {
                if (actor.getActorId() == null || actor.getActorId() == 0) {
                    actor.setActorId(System.currentTimeMillis());
                    actor = actorRepository.save(actor);
                }
                String sql = "insert into movie_actors(actor_id,movie_id) value(" + actor.getActorId() + "," + movieInfo.getMovieId() + ")";
                this.jdbcTemplate.execute(sql);
            }
        }
        if (movieDto.getMovieTypes() != null) {
            List<TypeInfo> typeInfos = movieDto.getMovieTypes();
            for (TypeInfo typeInfo : typeInfos) {
                if (typeInfo.getTypeId() == null || typeInfo.getTypeId() == 0) {
                    typeInfo.setTypeId(System.currentTimeMillis());
                    typeInfo = typeInfoRepository.save(typeInfo);
                }
                String sql = "insert into movie_types(type_id,movie_id) value(" + typeInfo.getTypeId() + "," + movieInfo.getMovieId() + ")";
                this.jdbcTemplate.execute(sql);
            }
        }
        movieInfoRepository.save(movieInfo);
        rabbitTemplate.convertAndSend("exchange.movie", "publish", JSON.toJSONString(movieDto));
        return movieDto;
    }

    @Override
    public Boolean deleteMovie(Long id) {
        String sql = "delete from movie_types where movie_id=" + id;
        jdbcTemplate.execute(sql);
        sql = "delete from movie_actors where movie_id=" + id;
        jdbcTemplate.execute(sql);
        sql = "delete from movie_info where movie_id=" + id;
        jdbcTemplate.execute(sql);
        this.rabbitTemplate.convertAndSend("exchange.movie", "delete", id);
        return true;
    }
}
