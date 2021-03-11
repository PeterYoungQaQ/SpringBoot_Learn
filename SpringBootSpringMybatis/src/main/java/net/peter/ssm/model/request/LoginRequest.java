package net.peter.ssm.model.request;
/*
 * @Author: Haoran
 * @Date: 2021/3/11 16:16
 * @Description: 登入 request
 */

public class LoginRequest {

    private String phone;

    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

