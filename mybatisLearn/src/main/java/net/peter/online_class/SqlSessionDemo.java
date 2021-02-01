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

            Video video = videoMapper.selectById(44);

            List<Video> videoList = videoMapper.selectList();

            System.out.println(video.toString());
            System.out.println(videoList.toString());

        }
    }
}
