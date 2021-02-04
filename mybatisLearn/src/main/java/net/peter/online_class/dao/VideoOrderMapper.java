package net.peter.online_class.dao;

import net.peter.online_class.domain.VideoOrder;

import java.util.List;

public interface VideoOrderMapper {

    /**
     * 查询全部订单，关联用户信息
     * @return
     */
    List<VideoOrder> queryVideoOrderList();
}
