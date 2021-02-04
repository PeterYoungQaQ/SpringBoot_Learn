package net.peter.online_class;

import net.peter.online_class.dao.VideoMapper;
import net.peter.online_class.domain.Video;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SqlSessionDemo {

    public static void main(String[] args) throws IOException {

        String resource = "config/mybatis-config.xml";

        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 构建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取session
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){

            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);

//             // 通过Mapper方式进行查询
//            Video video = videoMapper.selectById(44);
//
//            System.out.println(video.toString());

            // 通过@Select注解查询
//            List<Video> videoList = videoMapper.selectList();
//            System.out.println(videoList.toString());

            // 通过mapper方式进行多个参数查询
//            List<Video> videosList = videoMapper.selectByPointAndTitleLike(9.1,"");
//            System.out.println(videosList.toString());


//            // 通过mapper方法新增一条视频记录
//            Video videoAdd1 = new Video();
//            videoAdd1.setTitle("浩然同学");
//            videoAdd1.setCover_img("aa.png");
//            videoAdd1.setPoint(9.4);
//            videoAdd1.setC_id(20);
//            videoAdd1.setPrice(850);
//            videoAdd1.setCreate_time(new Date());
//            videoAdd1.setSummary("帅的不谈");
//
//            int rows1 = videoMapper.add(videoAdd1);
//            System.out.println(rows1);
//
//            System.out.println(videoAdd1.toString());
//
//            Video videoAdd2 = new Video();
//            videoAdd2.setTitle("浩然同学2");
//            videoAdd2.setCover_img("aa2.png");
//            videoAdd2.setPoint(9.3);
//            videoAdd2.setC_id(18);
//            videoAdd2.setPrice(1050);
//            videoAdd2.setCreate_time(new Date());
//            videoAdd2.setSummary("帅的不谈2");
//
//            // 通过mapper方法，新增多条视频数据
//            List<Video> videoList = new ArrayList<>();
//
//            videoList.add(videoAdd1);
//            videoList.add(videoAdd2);
//
//            int rows2 = videoMapper.addBatch(videoList);
//            System.out.println(rows2);
//
//            System.out.println(videoList.toString());


//            // 通过mapper方法进行更新update操作
//            Video videoUpdate = new Video();
//            videoUpdate.setCover_img("baidu.com");
//            videoUpdate.setTitle("今天天气很好!!");
//            videoUpdate.setId(59);
//
//            videoMapper.updateVideo(videoUpdate);

//            // 通过mapper方法进行选择性更新update操作
//            Video videoUpdate = new Video();
//            videoUpdate.setCover_img("baidu.com");
//            videoUpdate.setTitle("今天天气很好!");
//            videoUpdate.setId(60);
//
//            videoMapper.updateVideoSelective(videoUpdate);

//            // 根据时间和价格因素来删除记录
//            Map<String, Object> map = new HashMap<>();
//
//            map.put("create_time","2021-01-11 09:33:20");
//            map.put("price",100);
//
//            int rows = videoMapper.deleteByCreateTimeAndPrice(map);
//
//            System.out.println(rows);

//            // 使用ResultMap形式进行查询id查询
//            Video videoResultMap = videoMapper.selectBaseFieldByIdWithResultMap(45);
//            System.out.println(videoResultMap.toString());

        }
    }
}
