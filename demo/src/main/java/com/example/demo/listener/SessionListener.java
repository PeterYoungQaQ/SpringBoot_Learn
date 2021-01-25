package com.example.demo.listener;
/*
 * @Author: Haoran
 * @Date: 2021/1/25 21:50
 * @Description:
 */

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        System.out.println("sessionCreated====");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        System.out.println("sessionDestroyed====");
    }
}
