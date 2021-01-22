package com.example.demo.config;
/*
 * @Author: Haoran
 * @Date: 2021/1/22 16:21
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:pay.properties")
public class WXConfig {

    @Value("${wxpay.appid}")
    private String payAppId;

    @Value("${wxpay.secrecy}")
    private String paySecrecy;

    @Value("${wxpay.mechid}")
    private String payMechId;

    public String getPayAppId() {
        return payAppId;
    }

    public void setPayAppId(String payAppId) {
        this.payAppId = payAppId;
    }

    public String getPaySecrecy() {
        return paySecrecy;
    }

    public void setPaySecrecy(String paySecrecy) {
        this.paySecrecy = paySecrecy;
    }

    public String getPayMechId() {
        return payMechId;
    }

    public void setPayMechId(String payMechId) {
        this.payMechId = payMechId;
    }


}
