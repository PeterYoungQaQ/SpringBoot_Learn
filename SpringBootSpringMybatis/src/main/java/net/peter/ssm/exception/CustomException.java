package net.peter.ssm.exception;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 10:21
 * @Description: 自定义异常类
 */


public class CustomException extends RuntimeException {

    /**
     * 发生错误自定义状态码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    public CustomException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
