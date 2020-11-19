package com.xpf.design.patterns.publish_subscribe_mode;

/**
 * 订阅者接口
 */
public interface ISubscriber<M> {
    //订阅
    void subscribe(SubscribePublish subscribePublish);
    //取消订阅
    void unSubscribe(SubscribePublish subscribePublish);
    //
    void update(String publisher, M msg);
}
