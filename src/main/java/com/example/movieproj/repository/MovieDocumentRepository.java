package com.example.movieproj.repository;

import com.example.movieproj.entity.MovieDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface MovieDocumentRepository extends ElasticsearchRepository<MovieDocument, Long> {
    @Query("""
            {
                "multi_match": {
                  "query": "?0",
                  "type": "phrase",
                  "fields": [
                    "name",
                    "actors.name",
                    "story"
                  ]
                }
              }
            """)
    @Highlight(
            fields = {
                    @HighlightField(name = "name"),
                    @HighlightField(name = "actors.name"),
                    @HighlightField(name = "story")
            },
            parameters = @HighlightParameters(preTags = {"<span style='color:red;font-weight:bold;'>"}, postTags = {"</span>"})
    )
    SearchPage<MovieDocument> searchMovie(String keyword, Pageable pageable);

    @Query("""
             {"match_all": {}}
            """)
    SearchPage<MovieDocument> searchAll(Pageable pageable);

    @Query("""
            {
             "match":{
              "movie_id":?0
             }
            }
            """)
    List<MovieDocument> findByMovieId(Long movieId);
    @Query("""
            {
            "terms": {
                  "movie_type.name": [
                    "?0"
                  ]
                }
            }
            """)
    SearchPage<MovieDocument> findByMovieType(String movieType,Pageable pageable);
}
