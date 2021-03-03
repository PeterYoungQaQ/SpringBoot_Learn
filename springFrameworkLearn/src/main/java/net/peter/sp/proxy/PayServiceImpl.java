package net.peter.sp.proxy;
/*
 * @Author: Haoran
 * @Date: 2021/3/3 8:52
 * @Description:
 */

public class PayServiceImpl implements PayService{

    @Override
    public String callback(String outTradeNo) {
        System.out.println("支付回调");
        return outTradeNo;
    }

    @Override
    public int save(int userId, int productId) {
        System.out.println("下单信息");
        return productId;
    }
}
