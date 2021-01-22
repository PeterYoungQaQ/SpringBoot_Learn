package com.example.demo.controller;
/*
 * @Author: Haoran
 * @Date: 2021/1/21 17:57
 */

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

//    @PostMapping("login")
//    public JsonData login(String username, String pwd){
//
//        System.out.println("username= " + username +" ,password= " + pwd);
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user){
        System.out.println("user: " + user.toString());

        String token = userService.login(user.getUsername(), user.getPwd());
        return token != null? JsonData.buildSuccess(token): JsonData.buildError("账号密码错误");
    }

    @GetMapping("list")
    public JsonData listUser(){

        return JsonData.buildSuccess(userService.listUser());
    }
}
