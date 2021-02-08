package net.peter.sp;

import net.peter.sp.domain.Video;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Video video = (Video) applicationContext.getBean("video");

        System.out.println(video.toString());
    }
}
