package net.peter.ssm.service.impl;
/*
 * @Author: Haoran
 * @Date: 2021/3/8 10:45
 * @Description:
 */

import net.peter.ssm.dao.VideoMapper;
import net.peter.ssm.domain.Video;
import net.peter.ssm.service.VideoService;
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
