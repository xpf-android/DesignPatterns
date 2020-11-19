package com.xpf.design.patterns.publish_subscribe_mode;

public class SubscribeImplOne<M> implements ISubscriber<M> {

    public String name;

    public SubscribeImplOne(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(SubscribePublish subscribePublish) {
        subscribePublish.subscribe(this);
    }

    @Override
    public void unSubscribe(SubscribePublish subscribePublish) {
        subscribePublish.unSubscribe(this);
    }

    @Override
    public void update(String publisher, M m) {
        System.out.println(name + "收到" + publisher+ "发来的消息：" + m.toString());
    }
}
