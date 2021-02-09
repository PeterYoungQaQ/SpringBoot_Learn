package net.peter.sp.domain;


public class Video2 {

    private int id;

    private String title;

    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Video2(){

    }

    public Video2(String title, int id, String summary){
        System.out.println("Video 带参数构造函数");
        this.title = title;
        this.id = id;
        this.summary = summary;
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
        return "Video2{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
