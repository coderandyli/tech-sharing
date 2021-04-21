package com.eports.design_pattern.proxy.case01;


/**
 * @description: 代理对象对，原有对象代码增强
 * @author: lizhenzhen
 * @date: 2021-04-21 17:34
 **/
public class StudentProxy implements Behavior {
    private Student behavior;

    public StudentProxy(Student behavior) {
        this.behavior = behavior;
    }

    @Override
    public void eat() {
        System.out.println("proxy eat before");
        behavior.eat();
        System.out.println("proxy eat after");
    }

    @Override
    public void say(String str) {
        System.out.println("proxy say before...");
        behavior.say(str);
        System.out.println("proxy say after...");
    }
}
