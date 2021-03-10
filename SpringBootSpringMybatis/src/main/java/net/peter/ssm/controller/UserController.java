package net.peter.ssm.controller;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 10:53
 * @Description:
 */

import net.peter.ssm.service.UserService;
import net.peter.ssm.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo){

        int rows = userService.save(userInfo);

        return rows == 1 ? JsonData.buildSuccess("注册成功") : JsonData.buildError("注册失败，请重试");

    }
}
