package com.example.demo.schedule;
/*
 * @Author: Haoran
 * @Date: 2021/1/27 21:25
 * @Description:
 */

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时统计订单，金额
 */
@Component
public class VideoOrderTask {

    // 每两秒执行一次
    // @Scheduled(fixedRate = 2000)
    // @Scheduled(cron = "*/1 * * * * *")
    @Scheduled(fixedDelay = 2000)
    public void sun() throws InterruptedException {

        // 正常是从数据库获取数据
        System.out.println(LocalDateTime.now() + " 当前交易额 = " + Math.random());

//        Thread.sleep(4000L);
    }
}
