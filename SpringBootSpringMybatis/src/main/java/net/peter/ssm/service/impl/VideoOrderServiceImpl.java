package net.peter.ssm.service.impl;
/*
 * @Author: Haoran
 * @Date: 2021/3/13 9:51
 * @Description:
 */

import net.peter.ssm.dao.*;
import net.peter.ssm.exception.CustomException;
import net.peter.ssm.model.entity.Episode;
import net.peter.ssm.model.entity.PlayRecord;
import net.peter.ssm.model.entity.Video;
import net.peter.ssm.model.entity.VideoOrder;
import net.peter.ssm.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    /**
     * 下单操作
     * 未来可能会有优惠券等等其他的功能
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional(rollbackFor = CustomException.class)
    public int saveVideoOrder(int userId, int videoId) {

        // 判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.
                findByUserIdAndVideoIdAndState(userId, videoId, 1);

        if (videoOrder != null){
            return 0;
        }

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();

        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);

        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        // 生成播放记录
        if (rows  == 1){

            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);

            if (episode == null){
                throw new CustomException(-1,"视频没有集信息");
            }
            PlayRecord playRecord = new PlayRecord();

            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);

            playRecordMapper.saveRecord(playRecord);
        }

        return rows;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {

        return videoOrderMapper.listOrderByUserId(userId);
    }
}
