package net.peter.ssm.model.entity;
/*
 * @Author: Haoran
 * @Date: 2021/3/13 16:29
 * @Description:
 */


import java.util.Date;

/**
 * 小滴课堂  播放记录
 *
 *  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 *   `user_id` int(11) DEFAULT NULL,
 *   `video_id` int(11) DEFAULT NULL,
 *   `current_num` int(11) DEFAULT NULL COMMENT '当前播放第几集',
 *   `episode_id` int(11) DEFAULT NULL COMMENT '当前播放第几集视频id',
 *   `create_time` datetime DEFAULT NULL,
 */
public class PlayRecord {


    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Integer currentNum;


    private Integer episodeId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}


