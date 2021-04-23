package com.eports.design_pattern.proxy.case01;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-23 13:57
 **/
public class Application {
    public static void main(String[] args) {
        StudentProxy studentProxy = new StudentProxy(new Student());
        studentProxy.eat();
        studentProxy.say("my name is zhenzhenli");
    }
}
