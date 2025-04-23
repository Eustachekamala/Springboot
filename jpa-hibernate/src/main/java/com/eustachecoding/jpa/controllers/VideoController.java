package com.eustachecoding.jpa.controllers;

import com.eustachecoding.jpa.models.Video;
import com.eustachecoding.jpa.repositories.VideoRepository;
import com.eustachecoding.jpa.services.VideoService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {
    private final VideoService videoService;
    private final VideoRepository videoRepository;

    public VideoController(VideoService videoService, VideoRepository videoRepository) {
        this.videoService = videoService;
        this.videoRepository = videoRepository;
    }

    @GetMapping("/authors/videos/{id}")
    public Video getVideoById(@PathVariable Integer id) {
        return videoService.findVideoById(id);
    }

    @PatchMapping("/authors/videos/update/{id}")
    public Video updateVideo(@PathVariable Integer id, @RequestBody Video video) {
        return videoRepository.findById(id)
                .map( existing -> {
                    existing.setName(video.getName());
                    return videoRepository.save(existing);
                })
                .orElse(null);
    }
}
