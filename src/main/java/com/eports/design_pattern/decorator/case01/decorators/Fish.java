package com.eports.design_pattern.decorator.case01.decorators;

import com.eports.design_pattern.decorator.case01.AbstractLunch;

/**
 * @description: Fish
 * @author: lizhenzhen
 * @date: 2021-04-20 18:15
 **/
public class Fish extends AbstractLunch {
    private AbstractLunch lunch;

    public Fish(AbstractLunch lunch) {
        this.lunch = lunch;
    }

    @Override
    public String eat() {
        return lunch.eat() + "、fish";
    }

    @Override
    public double cost() {
        System.out.println("鱼6块");
        return lunch.cost() + 6;
    }
}
