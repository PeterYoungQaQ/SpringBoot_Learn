package com.example.demo.service;/*
 * @Author: Haoran
 * @Date: 2021/1/21 16:00
 */

import com.example.demo.domain.User;

import java.util.List;

public interface UserService {

    String login(String username, String pwd);

    List<User> listUser();
}
