package com.eports.design_pattern.decorator.case01;

import com.eports.design_pattern.decorator.case01.decorators.Fish;
import com.eports.design_pattern.decorator.case01.decorators.Meat;
import com.eports.design_pattern.decorator.case01.decorators.Vegetables;

/**
 * @description: Application
 * @author: lizhenzhen
 * @date: 2021-04-20 18:17
 **/
public class Application {
    public static void main(String[] args) {
        /**
         * {@link Fish}、{@link Meat}、{@link Vegetables} 都属于{@link Lunch}类的装饰类
         * {@link Fish}、{@link Meat}、{@link Vegetables}、{@link Lunch}都继承自{@link AbstractLunch}
         *
         */
        AbstractLunch lunch = new Lunch(),
                fish = new Fish(lunch),
                meat = new Meat(fish),
                vegetables = new Vegetables(meat);

        System.out.println(vegetables.eat() + "; A total of " + vegetables.cost() + " yuan");
    }
}
