package net.peter.ssm.model.request;
/*
 * @Author: Haoran
 * @Date: 2021/3/13 9:47
 * @Description:
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoOrderRequest {

    @JsonProperty("video_id")
    private int videoId;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
