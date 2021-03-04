package net.peter.sp.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/4 9:30
 * @Description:
 */

import net.peter.sp.domain.Video;

public class VideoServiceImpl implements VideoService{

    @Override
    public int save(Video video) {
        System.out.println("保存video");
        return 1;
    }

    @Override
    public Video findById(int id) {
        System.out.println("根据id查询视频");
        return new Video();
    }
}
