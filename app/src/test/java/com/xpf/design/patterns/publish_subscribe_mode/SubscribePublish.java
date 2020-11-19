package com.xpf.design.patterns.publish_subscribe_mode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class SubscribePublish<M> {
    //订阅器名称
    private String name;
    //订阅器队列容量
    final int QUEUE_CAPACITY = 5;
    //订阅器存储队列
    private BlockingQueue<Msg> queue = new ArrayBlockingQueue<Msg>(QUEUE_CAPACITY);
    //订阅者
    private List<ISubscriber> subscribers = new ArrayList<ISubscriber>();

    public SubscribePublish(String name) {
        this.name = name;
    }

    public void publish(String publisher, M m, boolean isInstantMsg) {
        if (isInstantMsg) {
            update(publisher, m);
            return;
        }
        Msg<M> msg = new Msg<M>(publisher);
        if (!queue.offer(msg)) {
            update();
        }
    }

    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void update() {
        Msg msg = null;
        while ((msg = queue.peek()) != null) {
            this.update(msg.getPublisher(), (M) msg.getMsg());
        }
    }

    public void update(String publisher, M m) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(publisher, m);
        }
    }
}
