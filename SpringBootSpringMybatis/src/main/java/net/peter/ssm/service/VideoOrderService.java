package net.peter.ssm.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/13 9:50
 * @Description:
 */

import net.peter.ssm.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {

    /**
     * 根据用户id查询用户下单信息
     * @param userId
     * @param videoId
     * @return
     */
    int saveVideoOrder(int userId, int videoId);

    /**
     * 根据用户id查询下单视频列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(Integer userId);
}
