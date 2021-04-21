package com.eports.design_pattern.interpreter.case02.expression;

import com.eports.design_pattern.interpreter.case02.Expresson;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 14:42
 **/
public class NumberExpression implements Expresson {
    private long number;

    public NumberExpression(long number) {
        this.number = number;
    }

    public NumberExpression(String number) {
        this.number = Long.parseLong(number);
    }

    @Override
    public long interpret() {
        return this.number;
    }
}
