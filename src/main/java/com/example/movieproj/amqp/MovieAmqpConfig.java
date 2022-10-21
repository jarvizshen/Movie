package com.example.movieproj.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieAmqpConfig {

    public DirectExchange DataSyncExchange(){
        return new DirectExchange("exchange.movie");
    }

    @Bean
    public Queue PublishMovieQueue(){
        return new Queue("queue.movie.publish");
    }
    @Bean
    public Binding bindingPublish(){
        return
                BindingBuilder.bind(PublishMovieQueue()).to(DataSyncExchange()).with("publish");
    }

    @Bean
    public Queue DeleteMovieQueue(){
        return new Queue("queue.movie.delete");
    }
    @Bean
    public Binding bindingDelete(){
        return
                BindingBuilder.bind(DeleteMovieQueue()).to(DataSyncExchange()).with("delete");
    }

}
