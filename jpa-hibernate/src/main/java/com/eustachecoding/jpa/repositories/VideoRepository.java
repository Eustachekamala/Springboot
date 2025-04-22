package com.eustachecoding.jpa.repositories;

import com.eustachecoding.jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
