package net.peter.ssm.dao;
/*
 * @Author: Haoran
 * @Date: 2021/3/8 10:42
 * @Description:
 */

import net.peter.ssm.domain.Video;
import net.peter.ssm.domain.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {

    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 首页轮播图列表
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 查询视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);
}
