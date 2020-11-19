package com.xpf.design.patterns.observer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


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

