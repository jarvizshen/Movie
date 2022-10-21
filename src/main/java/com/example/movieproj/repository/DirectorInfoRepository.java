package com.example.movieproj.repository;

import com.example.movieproj.entity.DirectorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorInfoRepository extends JpaRepository<DirectorInfo,Long> {
}
