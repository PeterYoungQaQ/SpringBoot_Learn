package com.example.demo.service.impl;/*
 * @Author: Haoran
 * @Date: 2021/1/21 15:43
 */

import com.example.demo.domain.Video;
import com.example.demo.mapper.VideoMapper;
import com.example.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }
}
