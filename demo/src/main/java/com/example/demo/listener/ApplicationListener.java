package com.example.demo.listener;
/*
 * @Author: Haoran
 * @Date: 2021/1/25 21:25
 * @Description:
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 应用上下文监听器
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("contextInitialized====");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("contextDestroyed====");
    }
}
