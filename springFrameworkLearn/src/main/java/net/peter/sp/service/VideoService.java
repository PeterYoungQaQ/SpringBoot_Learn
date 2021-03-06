package net.peter.sp.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/4 9:29
 * @Description:
 */

import net.peter.sp.domain.Video;

public interface VideoService {

    int save(Video video);

    Video findById(int id);

    void printConfig();
}


