package com.xpf.design.patterns.publish_subscribe_mode;

public class Msg<M> {
    private String publisher;
    private M m;


    public Msg(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public M getMsg() {
        return m;
    }

    public void setMsg(M m) {
        this.m = m;
    }
}
