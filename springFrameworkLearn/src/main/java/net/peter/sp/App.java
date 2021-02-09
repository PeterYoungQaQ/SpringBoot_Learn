package net.peter.sp;

import net.peter.sp.domain.Video;
import net.peter.sp.domain.VideoOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        testScope(applicationContext);

        testInject(applicationContext);
    }

    /**
     * 测试scope作用域范围
     * @param context
     */
    private static void testScope(ApplicationContext context){
        Video video1 = (Video) context.getBean("video");

        Video video2 = (Video) context.getBean("video");

        // 判断引用地址，即内存地址是否相同
        System.out.println(video1 == video2);


//        VideoOrder videoOrder= (VideoOrder) Context.getBean("videoOrder");
//        System.out.println(videoOrder.getVideo().getId());
//        System.out.println(videoOrder.toString());

    }

    /**
     * 测试inject注入的过程
     * @param context
     */
    private static void testInject(ApplicationContext context){

        Video video = (Video) context.getBean("video");
        System.out.println(video.getTitle());

    }
}
