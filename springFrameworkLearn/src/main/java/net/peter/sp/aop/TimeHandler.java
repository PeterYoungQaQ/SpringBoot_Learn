package net.peter.sp.aop;
/*
 * @Author: Haoran
 * @Date: 2021/3/4 9:32
 * @Description:
 */

import java.time.LocalDateTime;

/**
 * 横切关注点
 */
public class TimeHandler {

    public void printBefore(){
        System.out.println("打印开始日志时间 = " + LocalDateTime.now().toString());
    }

    public void printAfter(){
        System.out.println("打印结束日志时间 = " + LocalDateTime.now().toString());
    }
}
