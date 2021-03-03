package net.peter.sp.proxy;
/*
 * @Author: Haoran
 * @Date: 2021/3/3 8:57
 * @Description: 代理实现
 */

public class ProxyTest {

    public static void main(String[] args) {

//        PayService payService = new PayServiceImpl();
//
//        System.out.println(payService.callback("sydy23233"));

//        PayService payService = new StaticProxyPayServiceImpl(new PayServiceImpl());
//        payService.save(20,33);
//
//        payService.callback("sduud222");

        // jdk动态代理
        JdkProxy jdkProxy = new JdkProxy();

        // 获取代理类对象
        PayService payServiceProxy = (PayService) jdkProxy.newProxyInstance(new PayServiceImpl());

        payServiceProxy.callback("qqnum1");

        payServiceProxy.save(23,11);
    }
}
