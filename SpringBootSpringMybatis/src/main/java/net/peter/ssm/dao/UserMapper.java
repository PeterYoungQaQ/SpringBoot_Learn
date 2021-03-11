package net.peter.ssm.dao;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 10:55
 * @Description:
 */

import net.peter.ssm.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    int save(User user);

    User findByPhone(@Param("phone") String phone);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String md5);
}
