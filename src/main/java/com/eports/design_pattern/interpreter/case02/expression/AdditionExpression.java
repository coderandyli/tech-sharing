package com.eports.design_pattern.interpreter.case02.expression;

import com.eports.design_pattern.interpreter.case02.Expresson;

/**
 * @description: 加法表达式
 * @author: lizhenzhen
 * @date: 2021-04-21 14:38
 **/
public class AdditionExpression implements Expresson {
    private Expresson expr1;
    private Expresson expr2;

    public AdditionExpression(Expresson expr1, Expresson expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public long interpret() {
        return expr1.interpret() + expr2.interpret();
    }
}
