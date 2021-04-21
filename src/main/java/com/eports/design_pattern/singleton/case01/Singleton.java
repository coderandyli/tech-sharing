package com.eports.design_pattern.singleton.case01;

/**
 * @description: DCL方式实现的单例
 * @author: lizhenzhen
 * @date: 2021-04-21 15:13
 **/
public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {
    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
