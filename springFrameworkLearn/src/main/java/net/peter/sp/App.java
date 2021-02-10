package net.peter.sp;

import net.peter.sp.domain.Video;
import net.peter.sp.domain.Video2;
import net.peter.sp.domain.VideoOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        testScope(applicationContext);

        testInject(applicationContext);

//        testCollection(applicationContext);

//        testSucceed(applicationContext);

//        testInitAndDestroy(applicationContext);


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




    }

    /**
     * 测试inject注入的过程
     * @param context
     */
    private static void testInject(ApplicationContext context){

//        Video video = (Video) context.getBean("video");
//        System.out.println(video.getTitle());

        VideoOrder videoOrder= (VideoOrder) context.getBean("videoOrder");
        System.out.println(videoOrder.getVideo().getId());

    }

    /**
     * 测试List和Map格式注入
     * @param context
     */
//    private static void testCollection(ApplicationContext context){
//
//        Video video = (Video) context.getBean("video");
//        System.out.println(video.getChapterList().toString());
//        System.out.println(video.getVideoMap().values().toString());
//    }

    /**
     * 测试bean继承属性
     * @param context
     */
    private static void testSucceed(ApplicationContext context){
        Video2 video2 = (Video2) context.getBean("video2");
        System.out.println(video2.toString());
    }

    /**
     * 测试bean的初始化和销毁过程
     * @param context
     */
    private static void testInitAndDestroy(ApplicationContext context){

        Video video = (Video) context.getBean("video");
        System.out.println(video.getTitle());
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}
