package net.peter.online_class.domain;

import java.util.Date;
import java.util.List;

public class User {

    private int id;

    private String name;

    private String pwd;

    private String headImg;

    private String phone;

    private Date createTime;

    private List<VideoOrder> videoOrderList;

    public List<VideoOrder> getVideoOrderList() {
        return videoOrderList;
    }

    public void setVideoOrderList(List<VideoOrder> videoOrderList) {
        this.videoOrderList = videoOrderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
