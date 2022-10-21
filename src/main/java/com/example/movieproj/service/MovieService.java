package com.example.movieproj.service;

import com.example.movieproj.entity.MovieDocument;
import com.example.movieproj.service.dto.MovieDto;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.stereotype.Service;

public interface MovieService {

    /**
     * 搜索影片库:关键字在影片名称、剧情、演员中进行搜索
     * @param keyword 搜索关键字
     * @param page ⻚码
     * @param size ⻚⻓ * @return
     */
    SearchPage<MovieDocument> searchMovie(String keyword,Integer page, Integer size);

    SearchPage<MovieDocument> searchMovieByType(String movieType,Integer page, Integer size);

    /**
     * 发布影片
     * @param movieDto 待发布的影片数据对象 * @return 发布成功后的影片数据对象 */
    MovieDto publishMovie(MovieDto movieDto);


    /**
     * 删除指定影片
     * @param id 指定的影片id * @return
     */
    Boolean deleteMovie(Long id);
}
