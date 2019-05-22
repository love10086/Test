package com.gemall.library.bean;

import java.io.Serializable;

public class PublicBean implements Serializable {



    private String action;//区分你的意图
    private Object data[];

    private String msg;// 描述Bean意图  无实际作用

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object ... data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
