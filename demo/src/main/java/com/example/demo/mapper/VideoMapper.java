package com.example.demo.mapper;/*
 * @Author: Haoran
 * @Date: 2021/1/21 15:44
 */

import com.example.demo.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();

    static{
        videoMap.put(1, new Video(1,"Peter"));
        videoMap.put(2, new Video(2,"Nancy"));
        videoMap.put(3, new Video(3,"Porter"));
        videoMap.put(4, new Video(4,"James"));
        videoMap.put(5, new Video(5,"Bryant"));
        videoMap.put(6, new Video(6,"Ewing"));
        videoMap.put(7, new Video(7,"Howard"));
        videoMap.put(8, new Video(8,"Howard"));
    }

    public List<Video> listVideo(){
        return new ArrayList<>(videoMap.values());
    }

}
