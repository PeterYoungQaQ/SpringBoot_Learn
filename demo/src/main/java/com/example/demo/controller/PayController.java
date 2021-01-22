package com.example.demo.controller;
/*
 * @Author: Haoran
 * @Date: 2021/1/22 16:08
 */

import com.example.demo.config.WXConfig;
import com.example.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pub/pay")
@PropertySource({"classpath:pay.properties"})
public class PayController implements Serializable {

//    @Value("${wxpay.appid}")
//    private String payAppId;
//
//    @Value("${wxpay.secrecy}")
//    private String paySecrecy;

    @Autowired
    private WXConfig wxConfig;

    @GetMapping("get_pay_config")
    private JsonData payConfig(){

        Map<String, String> map = new HashMap<>();
        map.put("appid",wxConfig.getPayAppId());
        map.put("secrecy",wxConfig.getPaySecrecy());
        return JsonData.buildSuccess(map);
    }

    @RequestMapping("exception_test")
    private JsonData testExt(){

        int i = 1/0;

        return JsonData.buildSuccess("");
    }
}
