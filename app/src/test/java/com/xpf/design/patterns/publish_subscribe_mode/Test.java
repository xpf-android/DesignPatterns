package com.xpf.design.patterns.publish_subscribe_mode;

/**
 * 意思就是发布者和订阅者不知道对方的存在。需要
 * 一个第三方组件，叫做信息中介，它将订阅者和发
 * 布者串联起来，它过滤和分配所有输入的消息
 */
public class Test {
    @org.junit.Test
    public void test() {
        SubscribePublish<String> subscribePublish = new SubscribePublish<String>("订阅器");
        IPublisher<String> publisher1 = new PublisherImplOne<String>("发布者1");
        IPublisher<String> publisher2 = new PublisherImplOne<String>("发布者2");
        ISubscriber<String> subscriber1 = new SubscribeImplOne<String>("订阅者1");
        ISubscriber<String> subscriber2 = new SubscribeImplOne<String>("订阅者2");
        subscriber1.subscribe(subscribePublish);
        subscriber2.subscribe(subscribePublish);
//        subscriber2.unSubscribe(subscribePublish);
        publisher1.publish(subscribePublish, "welcome", true);
        publisher1.publish(subscribePublish, "to", true);
        publisher1.publish(subscribePublish, "china", false);

//        publisher2.publish(subscribePublish, "how", true);
//        publisher2.publish(subscribePublish, "are", true);
        publisher2.publish(subscribePublish, "you", false);
        publisher2.publish(subscribePublish, "!", false);
        publisher2.publish(subscribePublish, "...", false);
        publisher2.publish(subscribePublish, ">", false);
//        publisher2.publish(subscribePublish, "<", false);

        /**
         * 订阅者1收到发布者1发来的消息：welcome
         * 订阅者2收到发布者1发来的消息：welcome
         * 订阅者1收到发布者1发来的消息：to
         * 订阅者2收到发布者1发来的消息：to
         */

    }
}
