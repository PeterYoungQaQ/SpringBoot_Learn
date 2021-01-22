package com.example.demo.mapper;/*
 * @Author: Haoran
 * @Date: 2021/1/21 15:56
 */

import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("Peter",new User(1,"Peter","123"));
        userMap.put("Jack",new User(2,"Jack","1234"));
        userMap.put("Tom",new User(3,"Tom","12345"));
    }
    public User login(String username, String pwd){
        User user = userMap.get(username);

        if (user == null){
            return null;
        }

        if (user.getPwd().equals(pwd)){
            return user;
        }
        return null;
    }

    public List<User> listUser(){
        return new ArrayList<>(userMap.values());
    }
}
