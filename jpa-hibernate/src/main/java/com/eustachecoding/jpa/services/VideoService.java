package com.eustachecoding.jpa.services;

import com.eustachecoding.jpa.models.Video;
import com.eustachecoding.jpa.repositories.VideoRepository;
import org.springframework.stereotype.Service;


@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    //Get video by id
    public Video findVideoById(Integer id) {
        return videoRepository.findAllByOrderById()
                .stream()
                .filter(video -> video
                        .getId().equals(id))
                .findFirst().orElse(null);
    }
}
