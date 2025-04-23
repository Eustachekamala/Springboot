package com.eustachecoding.jpa.repositories;

import com.eustachecoding.jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    //select * from video order by id asc
    List<Video> findAllByOrderById();

}
