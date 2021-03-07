package net.peter.ssm.controller;
/*
 * @Author: Haoran
 * @Date: 2021/3/7 9:32
 * @Description:
 */

import net.peter.ssm.domain.User;
import net.peter.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public Object save(){

        User user = new User();

        user.setName("浩然");
        user.setId(7);
        user.setPhone("8868334");

        userService.save(user);

        return user;
    }
}
