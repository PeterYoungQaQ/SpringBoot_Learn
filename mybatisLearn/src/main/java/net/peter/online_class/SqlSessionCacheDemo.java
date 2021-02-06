package net.peter.online_class;

import net.peter.online_class.dao.VideoMapper;
import net.peter.online_class.dao.VideoOrderMapper;
import net.peter.online_class.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionCacheDemo {

    public static void main(String[] args) throws IOException {

        String resource = "config/mybatis-config.xml";

        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 构建sessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 二级缓存测试
        try {
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            VideoMapper videoMapper1 = sqlSession1.getMapper(VideoMapper.class);

            Video video1 = videoMapper1.selectById(44);
            System.out.println(video1.toString());

            sqlSession1.commit();

            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            VideoMapper videoMapper2 = sqlSession2.getMapper(VideoMapper.class);

            Video video2 = videoMapper2.selectById(44);
            System.out.println(video2.toString());


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
