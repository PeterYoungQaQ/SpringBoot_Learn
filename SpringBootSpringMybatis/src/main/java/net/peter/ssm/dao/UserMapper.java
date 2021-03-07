package net.peter.ssm.dao;
/*
 * @Author: Haoran
 * @Date: 2021/3/7 9:46
 * @Description:
 */

import net.peter.ssm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Insert("insert into user(name,phone) value(#{name},#{phone})")
    int save(User user);
}
