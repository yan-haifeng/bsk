package com.zime.bsk.util;

import java.util.List;

public class JsonUtil<T> {
    private int code; // 0：成功，1：失败
    private String session;
    private String msg;
    private int count = 0;
    private List<T> data;
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    //改
    public JsonUtil addMsg(String msg){
        this.setMsg(msg);
        return this;
    }

    public JsonUtil addSession(String session){
        this.setSession(session);
        return this;
    }

    public JsonUtil addCount(int value) {
        this.setCount(value);
        return this;
    }

    public JsonUtil addData(List<T> data) {
        this.setData(data);
        return this;
    }

    public static JsonUtil success() {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setCode(0);
        jsonUtil.setMsg("处理成功");
        return jsonUtil;
    }
    public static JsonUtil success(String msg) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setCode(0);
        jsonUtil.setMsg(msg);
        return jsonUtil;
    }

    public static JsonUtil fail() {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setCode(1);
        jsonUtil.setMsg("处理失败");
        return jsonUtil;
    }
    public static JsonUtil fail(String msg) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setCode(1);
        jsonUtil.setMsg(msg);
        return jsonUtil;
    }

}
