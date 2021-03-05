package net.peter.sp.dao;
/*
 * @Author: Haoran
 * @Date: 2021/3/5 9:19
 * @Description:
 */

import org.springframework.stereotype.Repository;

@Repository("videoDao")
public class VideoDao {

    public void test(){
        System.out.println("video Dao test");
    }
}
