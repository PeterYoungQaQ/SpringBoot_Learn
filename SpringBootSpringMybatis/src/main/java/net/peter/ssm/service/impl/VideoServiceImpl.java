package net.peter.ssm.service.impl;
/*
 * @Author: Haoran
 * @Date: 2021/3/8 10:45
 * @Description:
 */

import net.peter.ssm.config.CacheKeyManager;
import net.peter.ssm.dao.VideoMapper;
import net.peter.ssm.model.entity.Video;
import net.peter.ssm.model.entity.VideoBanner;
import net.peter.ssm.service.VideoService;
import net.peter.ssm.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }

    @Override
    public List<VideoBanner> listBanner() {

        try{
            Object cacheObject = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
                        List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                        System.out.println("从数据库中找轮播图列表");
                        return bannerList;
                    });

            if (cacheObject instanceof List){

                return (List<VideoBanner>) cacheObject;
            }
            }
                catch (Exception e){
                e.printStackTrace();
            }

            return null;
    }

    @Override
    public Video findDetailById(int videoId) {

        // 需要使用mybatis关联复杂查询

        return videoMapper.findDetailById(videoId);
    }
}
