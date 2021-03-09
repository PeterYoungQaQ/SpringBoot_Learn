package net.peter.ssm.controller;
/*
 * @Author: Haoran
 * @Date: 2021/3/8 11:13
 * @Description:
 */

import net.peter.ssm.domain.Video;
import net.peter.ssm.service.VideoService;
import net.peter.ssm.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("listVideo")
    public Object listVideo(){

        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);
    }
}
