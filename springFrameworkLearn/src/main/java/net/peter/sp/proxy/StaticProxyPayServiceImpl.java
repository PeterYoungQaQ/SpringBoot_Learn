package net.peter.sp.proxy;
/*
 * @Author: Haoran
 * @Date: 2021/3/3 9:00
 * @Description:
 */

public class StaticProxyPayServiceImpl implements PayService{

    private PayService payService;

    public StaticProxyPayServiceImpl(PayService payService){
        this.payService = payService;
    }


    @Override
    public String callback(String outTradeNo) {

        System.out.println("静态代理启动");
        String result = payService.callback(outTradeNo);
        System.out.println("静态代理关闭");
        return result;
    }

    @Override
    public int save(int userId, int productId) {
        System.out.println("静态代理启动version 2");
        return payService.save(userId, productId);
    }
}
