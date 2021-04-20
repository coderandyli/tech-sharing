package com.eports.design_pattern.decorator.case01;

/**
 * @description: AbstractLunch实现类
 * @author: lizhenzhen
 * @date: 2021-04-20 17:55
 **/
public class Lunch extends AbstractLunch{
    @Override
    public String eat() {
        return "the lunch has rice";
    }

    @Override
    public double cost() {
        System.out.println("米饭2块");
        return 2;
    }
}
