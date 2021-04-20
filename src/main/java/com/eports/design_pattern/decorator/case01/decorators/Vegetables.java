package com.eports.design_pattern.decorator.case01.decorators;

import com.eports.design_pattern.decorator.case01.AbstractLunch;

/**
 * @description: 蔬菜
 * @author: lizhenzhen
 * @date: 2021-04-20 18:02
 **/
public class Vegetables extends AbstractLunch {
    private AbstractLunch lunch;

    public Vegetables(AbstractLunch lunch) {
        this.lunch = lunch;
    }

    @Override
    public String eat() {
        return lunch.eat() + "、vegetables";
    }

    @Override
    public double cost() {
        System.out.println("蔬菜4块");
        return lunch.cost() + 4;
    }
}
