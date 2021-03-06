package com.eports.design_pattern.interpreter.case01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 14:28
 **/
public class ExpressionInterpreter {
    /**
     * 先入先出的队列
     */
    private Deque<Long> numbers = new LinkedList<>();

    public long interpret(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        // 获取数据到numbers
        for (int i = 0; i < (length + 1) / 2; ++i) {
            numbers.addLast(Long.parseLong(elements[i]));
        }

        // 基于先进先出的队列，不断入栈出栈，进行运算，直至运算完毕；
        for (int i = (length + 1) / 2; i < length; ++i) {
            String operator = elements[i];
            boolean isValid = checkIfValid(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }

            long number1 = numbers.pollFirst();
            long number2 = numbers.pollFirst();
            long result = 0;
            if (operator.equals("+")) {
                result = number1 + number2;
            } else if (operator.equals("-")) {
                result = number1 - number2;
            } else if (operator.equals("*")) {
                result = number1 * number2;
            } else if (operator.equals("/")) {
                result = number1 / number2;
            }
            numbers.addFirst(result);
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }

        return numbers.pop();
    }

    /**
     * 校验是否有效
     */
    private boolean checkIfValid(String operator) {
        return "+".equals(operator) || "-".equals(operator)
                || "*".equals(operator) || "/".equals(operator);
    }
}
