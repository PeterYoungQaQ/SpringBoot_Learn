package net.peter.sp;

import net.peter.sp.domain.Video;
import net.peter.sp.domain.VideoOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        testScope(applicationContext);
    }

    private static void testScope(ApplicationContext Context){
        Video video1 = (Video) Context.getBean("video");

        Video video2 = (Video) Context.getBean("video");

        // 判断引用地址，即内存地址是否相同
        System.out.println(video1 == video2);


//        VideoOrder videoOrder= (VideoOrder) Context.getBean("videoOrder");
//
//        System.out.println(videoOrder.getVideo().getId());
//
//        System.out.println(videoOrder.toString());

    }
}
