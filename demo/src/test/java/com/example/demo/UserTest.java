package com.example.demo;
/*
 * @Author: Haoran
 * @Date: 2021/1/22 20:15
 */

import com.example.demo.controller.UserController;
import com.example.demo.domain.User;
import com.example.demo.utils.JsonData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class UserTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest(){
        User user = new User();
        user.setUsername("Peter");
        user.setPwd("123");

        JsonData jsonData = userController.login(user);

        System.out.println(jsonData.toString());

        Assert.assertEquals(0,jsonData.getCode());
    }
}
