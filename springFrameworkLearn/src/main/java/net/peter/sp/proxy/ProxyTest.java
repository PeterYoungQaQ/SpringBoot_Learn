package net.peter.sp.proxy;
/*
 * @Author: Haoran
 * @Date: 2021/3/3 8:57
 * @Description:
 */

public class ProxyTest {

    public static void main(String[] args) {

//        PayService payService = new PayServiceImpl();
//
//        System.out.println(payService.callback("sydy23233"));

        PayService payService = new StaticProxyPayServiceImpl(new PayServiceImpl());
        payService.save(20,33);

        payService.callback("sduud222");
    }
}
