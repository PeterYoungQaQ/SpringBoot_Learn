package net.peter.ssm.controller;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 10:53
 * @Description:
 */

import net.peter.ssm.model.entity.User;
import net.peter.ssm.model.request.LoginRequest;
import net.peter.ssm.service.UserService;
import net.peter.ssm.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo){

        int rows = userService.save(userInfo);

        return rows == 1 ? JsonData.buildSuccess("注册成功") : JsonData.buildError("注册失败，请重试");

    }

    /**
     * 登入接口
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());

        return token == null ? JsonData.buildError("登入失败，账号密码错误") : JsonData.buildSuccess(token);
    }


    /**
     * 通过token信息解密来查询用户信息接口
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");
        if (userId == null){
            return JsonData.buildError("查询失败");
        }

        User user = userService.findByUserId(userId);

        return JsonData.buildSuccess(user);

    }


}
