package net.peter.ssm.controller;
/*
 * @Author: Haoran
 * @Date: 2021/3/8 11:13
 * @Description:
 */

import net.peter.ssm.model.entity.Video;
import net.peter.ssm.model.entity.VideoBanner;
import net.peter.ssm.service.VideoService;
import net.peter.ssm.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;


    /**
     * 轮播图列表
     * @return
     */
    @GetMapping("listVideoBanner")
    public JsonData indexBanner(){

        List<VideoBanner> videoBannerList = videoService.listBanner();
//        int i = 1/0;
        return JsonData.buildSuccess(videoBannerList);
    }

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("listVideo")
    public JsonData listVideo(){

        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);
    }

    /**
     * 查询视频详情，包括章、集信息
     * @param videoId
     * @return
     */
    @GetMapping("findDetailById")
    public JsonData findDetailById(@RequestParam(value = "video_id") int videoId){

        Video video = videoService.findDetailById(videoId);

        return JsonData.buildSuccess(video);

    }
}
