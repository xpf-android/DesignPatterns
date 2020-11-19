package com.xpf.design.patterns.observer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 观察者模式
 * 模式定义：定义了对象之间的一对多依赖，让多个观察者同时监听某一个主题对象，
 * 当这个对象发生改变时，它的所有依赖着都会收到通知并更新/触发技能
 *
 * 应用场景：当更改一个对象的状态可能需要更改其它对象，
 * 并且实际的对象集事先未知或动态更改时，使用观察者模式
 *
 * 优点：
 * 1.符合开闭原则：添加新的观察者的时候只需要实现observer接口，添加到主题对象的容器列表，
 *   不需要修改已有观察者的代码
 * 2.可以在运行时建立对象之间的关系：可以动态的添加新的观察者，
 *   也可以以前的观察者移除掉。
 */
public class ObserverTest {
    @Test
    public void test() {
        Subject subject = new Subject();
        Task1 task1 = new Task1();
        subject.addObserver(task1);
        Task2 task2 = new Task2();
        subject.addObserver(task2);

        subject.notifyObserver("xxx");
        System.out.println("=============");
        subject.remove(task1);
        subject.notifyObserver("yyy");
    }

}

class Subject {
    //容器
    private List<Observer> container = new ArrayList<>();

    /**
     * 添加观察者到容器列表
      * @param observer
     */
    public void addObserver(Observer observer) {
        if (!container.contains(observer)) {
            container.add(observer);
        }
    }

    /**
     * 从容器列表移除观察者
     * @param observer
     */
    public void remove(Observer observer) {
        container.remove(observer);
    }

    public void notifyObserver(Object object) {
        for (Observer observer : container) {
            observer.update(object);
        }
    }
}

interface Observer{
    void update(Object object);
}

class Task1 implements Observer{
    @Override
    public void update(Object object) {
        System.out.println("task1 received: " + object);
    }
}

class Task2 implements Observer{
    @Override
    public void update(Object object) {
        System.out.println("task2 received: " + object);
    }
}

