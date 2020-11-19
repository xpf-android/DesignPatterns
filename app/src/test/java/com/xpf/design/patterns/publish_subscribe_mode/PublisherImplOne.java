package com.xpf.design.patterns.publish_subscribe_mode;

public class PublisherImplOne<M> implements IPublisher<M> {


    private String name;

    public PublisherImplOne(String name) {
        this.name = name;
    }
    @Override
    public void publish(SubscribePublish subscribePublish, M m, boolean isInstantMsg) {
        subscribePublish.publish(name, m, isInstantMsg);
    }
}
