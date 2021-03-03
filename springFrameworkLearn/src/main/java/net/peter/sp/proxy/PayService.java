package net.peter.sp.proxy;
/*
 * @Author: Haoran
 * @Date: 2021/3/3 8:51
 * @Description:
 */

public interface PayService {

    /**
     * 支付回调
     * @param outTradeNo
     * @return
     */
    String callback(String outTradeNo);

    /**
     * 下单
     * @param userId
     * @param productId
     * @return
     */
    int save(int userId, int productId);
}
