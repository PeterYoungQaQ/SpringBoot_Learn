package net.peter.ssm.service.impl;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 11:12
 * @Description: 自定义工具类
 */

import net.peter.ssm.dao.UserMapper;
import net.peter.ssm.model.entity.User;
import net.peter.ssm.service.UserService;
import net.peter.ssm.utils.CommonUtils;
import net.peter.ssm.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {

        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));

        if (user == null){
            return null;
        }else {
            return JWTUtils.geneJsonWebToken(user);
        }
    }

    @Override
    public int saveUser(Map<String, String> userInfo) {

        User user = parseToUser(userInfo);

        if (user != null){
            userMapper.saveUser(user);
        }else {
            return -1;
        }

        return 1;
    }

    @Override
    public User findByUserId(Integer userId) {

        return userMapper.findByUserId(userId);
    }

    /**
     * 解析User对象
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setName(userInfo.get("name"));
            String pwd = userInfo.get("pwd");
            // MD5加密设置
            user.setPwd(CommonUtils.MD5(pwd));
            user.setPhone(userInfo.get("phone"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());

            return user;
        }else {
            return null;
        }
    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg = {
            "https://www.keaidian.com/uploads/allimg/190108/co1Z10Q32551-0-8.jpg",
            "http://img.crcz.com/allimg/202002/16/1581821824131135.jpg",
            "https://img2.woyaogexing.com/2018/08/31/0d12b9a5862943d9b54b97f0cf5a34ab!400x400.jpeg",
            "https://img2.woyaogexing.com/2018/09/20/ff114b10de890e87!400x400_big.jpg",
            "https://www.keaidian.com/uploads/allimg/190429/29091916_7.jpeg",
            "https://img2.woyaogexing.com/2018/05/21/07822373b2493543!400x400_big.jpg"
    };

    /**
     * 随机生成头像
     * @return
     */
    private String getRandomImg(){

        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
