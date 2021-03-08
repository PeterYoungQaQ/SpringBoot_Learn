package net.peter.ssm.dao;
/*
 * @Author: Haoran
 * @Date: 2021/3/8 10:42
 * @Description:
 */

import net.peter.ssm.domain.Video;

import java.util.List;

public interface VideoMapper {

    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();
}
