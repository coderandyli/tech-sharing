package com.eports.design_pattern.proxy.case01;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 16:43
 **/
public class Student implements Behavior{
    @Override
    public void eat() {
        System.out.println("student eat....");
    }

    @Override
    public void say(String str) {
        System.out.println("student say....");
    }
}
