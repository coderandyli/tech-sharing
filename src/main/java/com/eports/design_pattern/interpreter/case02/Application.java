package com.eports.design_pattern.interpreter.case02;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 14:35
 **/
public class Application {
    public static void main(String[] args) {
        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        // ((8 - 3) + 2) * 4 = 28
        long result = interpreter.interpret("8 3 2 4 - + *");
        System.out.println(result);
    }
}
