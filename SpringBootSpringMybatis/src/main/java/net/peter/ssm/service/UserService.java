package net.peter.ssm.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 11:11
 * @Description:
 */

import net.peter.ssm.model.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 通过手机号和密码进行用户登入
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(String phone, String pwd);

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int saveUser(Map<String, String> userInfo);


    /**
     * 通过用户id查找用户信息
     * @param userId
     * @return
     */
    User findByUserId(Integer userId);
}
