package net.peter.ssm.utils;
/*
 * @Author: Haoran
 * @Date: 2021/3/9 9:12
 * @Description:
 */

public class JsonData {

    /**
     * 0表示成功，1表示处理中，-1表示失败
     */
    private Integer code;

    /**
     * 业务数据
     */
    private Object data;

    /**
     * 信息表示
     */
    private String msg;

    public JsonData(){}

    public JsonData(Integer code, Object data , String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 成功，不用返回数据
     * @return
     */
    public static JsonData buildSuccess(){
        return new JsonData(0, null, null);
    }

    public static JsonData buildSuccess(Object data){
        return new JsonData(0, data, null);
    }

    /**
     * 失败，返回错误信息，固定状态码
     * @param msg
     * @return
     */
    public static JsonData buildError(String msg){
        return new JsonData(-1, null, msg);
    }

    /**
     * 失败，返回自定义状态码和信息
     * @param code
     * @param msg
     * @return
     */
    public static JsonData buildError(Integer code, String msg){
        return new JsonData(code, null, msg);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
