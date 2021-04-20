package com.eports.design_pattern.chain_of_responsibility.case01.handler;

/**
 * @description: C处理器
 * @author: lizhenzhen
 * @date: 2021-04-20 17:20
 **/
public class HandlerC extends Handler{

    @Override
    public boolean doHandle() {
        boolean handled = false;
        // ignore business logic....
        System.out.println("class HandlerC; method handler()");
        return false;
    }
}
