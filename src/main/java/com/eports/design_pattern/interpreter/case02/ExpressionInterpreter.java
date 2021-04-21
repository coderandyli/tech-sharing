package com.eports.design_pattern.interpreter.case02;

import com.eports.design_pattern.interpreter.case02.expression.*;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 表达式解析
 * @author: lizhenzhen
 * @date: 2021-04-21 14:36
 **/
public class ExpressionInterpreter {
    /**
     * 先进先出
     */
    private Deque<Expresson> numbers = new LinkedList<>();

    public Long interpret(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i = 0; i < (length+1)/2; ++i) {
            numbers.addLast(new NumberExpression(elements[i]));
        }

        for (int i = (length+1)/2; i < length; ++i) {
            String operator = elements[i];
            boolean isValid = checkIfValid(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }

            Expresson exp1 = numbers.pollFirst();
            Expresson exp2 = numbers.pollFirst();

            Expresson combinedExp = null;
            if (operator.equals("+")) {
                combinedExp = new AdditionExpression(exp1, exp2);
            } else if (operator.equals("-")) {
                combinedExp = new SubstractionExpression(exp1, exp2);
            } else if (operator.equals("*")) {
                combinedExp = new MultiplicationExpression(exp1, exp2);
            } else if (operator.equals("/")) {
                combinedExp = new DivisionExpression(exp1, exp2);
            }
            long result = combinedExp.interpret();
            numbers.addFirst(new NumberExpression(result));
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }

        return numbers.pop().interpret();
    }

    private void fetchNumber(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i = 0; i < (length + 1) / 2; ++i) {
            numbers.addLast(new NumberExpression(elements[i]));
        }
    }

    private boolean checkIfValid(String operator) {
        return  "+".equals(operator) || "-".equals(operator)
                || "*".equals(operator) || "/".equals(operator);
    }
}
