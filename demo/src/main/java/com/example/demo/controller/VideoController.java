package com.example.demo.controller;/*
 * @Author: Haoran
 * @Date: 2021/1/20 16:24
 */

import com.example.demo.domain.Video;
import com.example.demo.service.VideoService;
import com.example.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("list")
    public JsonData list(){
        List<Video> list = videoService.listVideo();

        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideo(@RequestBody Video video){
        System.out.println(video.toString());
        return JsonData.buildSuccess("");
    }
}
