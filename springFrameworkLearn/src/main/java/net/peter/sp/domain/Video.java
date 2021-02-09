package net.peter.sp.domain;

import java.util.List;
import java.util.Map;

public class Video {

    private int id;

    private String title;

    private List<String> chapterList;

    private Map<Integer,String> videoMap;

    public Video(){

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

    public List<String> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<String> chapterList) {
        this.chapterList = chapterList;
    }

    public Map<Integer, String> getVideoMap() {
        return videoMap;
    }

    public void setVideoMap(Map<Integer, String> videoMap) {
        this.videoMap = videoMap;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", chapterList=" + chapterList +
                ", videoMap=" + videoMap +
                '}';
    }
}
