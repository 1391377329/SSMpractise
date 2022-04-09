package com.sqt.bean;

import java.util.HashMap;
import java.util.Map;

public class Message {

    private int statusCode;

    private String  msg;

    private Map<String ,Object> extendX =new HashMap<>();

    public static Message success(){
        Message result = new Message();
        result.setStatusCode(1);
        result.setMsg("执行成功!");
        return result;

    }
    public static Message failure(){
        Message result = new Message();
        result.setStatusCode(2);
        result.setMsg("执行失败!");
        return result;
    }

    public Message add(String key,Object value){
        this.extendX.put(key,value);
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtendX() {
        return extendX;
    }

    public void setExtendX(Map<String, Object> extendX) {
        this.extendX = extendX;
    }
}
