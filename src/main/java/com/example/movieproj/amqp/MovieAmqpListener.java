package com.example.movieproj.amqp;

import com.example.movieproj.entity.MovieDocument;
import com.example.movieproj.repository.MovieDocumentRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import javax.annotation.Resource;
import java.util.List;

public class MovieAmqpListener {
    MovieDocumentRepository movieDocumentRepository;
    public MovieAmqpListener(MovieDocumentRepository movieDocumentRepository){
        this.movieDocumentRepository = movieDocumentRepository;
    }

    @RabbitListener(queues = {"queue.movie.publish"})
    public void publishQueueListener(String movie){
        System.out.println(movie);
    }
    @RabbitListener(queues = {"queue.movie.delete"})
    public void deleteQueueListener(Long id){
        List<MovieDocument> documentList=this.movieDocumentRepository.findByMovieId(id);
        this.movieDocumentRepository.deleteAll(()-> documentList.iterator());
    }
}
