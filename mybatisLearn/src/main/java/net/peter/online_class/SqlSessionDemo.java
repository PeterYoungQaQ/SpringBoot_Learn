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
import java.util.List;

public class SqlSessionDemo {

    public static void main(String[] args) throws IOException {

        String resource = "config/mybatis-config.xml";

        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 构建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取session
        try (SqlSession sqlSession = sqlSessionFactory.openSession();){

            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);

            // 通过Mapper方式进行查询
//            Video video = videoMapper.selectById(44);
//
//            System.out.println(video.toString());

            // 通过@Select注解查询
//            List<Video> videoList = videoMapper.selectList();
//            System.out.println(videoList.toString());

            // 通过mapper方式进行多个参数查询
            List<Video> videosList = videoMapper.selectByPointAndTitleLike(8.7,"全新");
            System.out.println(videosList.toString());

        }
    }
}
