package net.peter.ssm.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 11:11
 * @Description:
 */

import net.peter.ssm.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserService {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

}
