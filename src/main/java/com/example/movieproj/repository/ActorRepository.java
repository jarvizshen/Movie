package com.example.movieproj.repository;

import com.example.movieproj.entity.ActorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorInfo,Long> {
}
