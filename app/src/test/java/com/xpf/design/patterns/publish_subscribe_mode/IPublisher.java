package com.xpf.design.patterns.publish_subscribe_mode;

/**
 * 发布者接口
 */
public interface IPublisher<M> {
    void publish(SubscribePublish subscribePublish, M m, boolean isInstantMsg);
}
