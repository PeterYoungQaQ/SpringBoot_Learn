package net.peter.ssm.controller;
/*
 * @Author: Haoran
 * @Date: 2021/3/8 11:13
 * @Description:
 */

import net.peter.ssm.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("listVideo")
    public Object listVideo(){
        return videoService.listVideo();
    }
}
