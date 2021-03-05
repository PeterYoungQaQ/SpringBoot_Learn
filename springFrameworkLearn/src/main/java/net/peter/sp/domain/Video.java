package net.peter.sp.domain;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Video {

    private int id;

    private String title;

    @PostConstruct
    public void init(){
        System.out.println("Video类做初始化操作");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Video类被销毁了");
    }


    public Video(){
        System.out.println("Video空类被调用");
    }

    public Video(String title, int id){
        System.out.println("Video 带参数构造函数");
        this.title = title;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        System.out.println("Video的getTitle方法被调用");
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
