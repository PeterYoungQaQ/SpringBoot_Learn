package net.peter.online_class.dao;

import net.peter.online_class.domain.User;
import net.peter.online_class.domain.VideoOrder;

import java.util.List;

public interface VideoOrderMapper {

    /**
     * 查询全部订单，关联用户信息，是一对一的关系
     * @return
     */
    List<VideoOrder> queryVideoOrderList();

    /**
     * 查询全部用户的订单，是一对多的关系
     * @return
     */
    List<User> queryUserOrder();
}
