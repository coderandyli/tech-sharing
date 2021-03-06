package com.eports.design_pattern.decorator.case01.decorators;

import com.eports.design_pattern.decorator.case01.AbstractLunch;

import java.util.Collections;

/**
 * @description: Meat
 * @author: lizhenzhen
 * @date: 2021-04-20 17:58
 **/
public class Meat extends AbstractLunch {

    private AbstractLunch lunch;

    public Meat(AbstractLunch lunch) {
        this.lunch = lunch;
    }

    @Override
    public String eat() {
        return this.lunch.eat() + "ใmeat";
    }

    @Override
    public double cost() {
        System.out.println("ๅ่8ๅ");
        return this.lunch.cost() + 8;
    }
}
