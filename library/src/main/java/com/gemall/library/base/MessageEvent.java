package com.gemall.library.base;

import java.io.Serializable;

public class MessageEvent implements Serializable {
    private Object message[];
    private String action;


    public  MessageEvent(){
    }



    public  MessageEvent(String action){
        this.action = action;
    }


    public  MessageEvent(String action,Object ... message){
        this.action = action;
        this.message = message;
    }



    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object[] getMessage() {
        return message;
    }

    public void setMessage(Object[] message) {
        this.message = message;
    }
}