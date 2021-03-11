package net.peter.ssm.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 11:11
 * @Description:
 */

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
    int save(Map<String, String> userInfo);

}
