package com.eports.design_pattern.chain_of_responsibility.case01;

import com.eports.design_pattern.chain_of_responsibility.case01.handler.HandlerA;
import com.eports.design_pattern.chain_of_responsibility.case01.handler.HandlerB;
import com.eports.design_pattern.chain_of_responsibility.case01.handler.HandlerC;

/**
 * @description: 启动类
 * @author: lizhenzhen
 * @date: 2021-04-20 17:17
 **/
public class Application {
    public static void main(String[] args) {
        HandleChain handleChain = new HandleChain();
        handleChain.addHandler(new HandlerA());
        handleChain.addHandler(new HandlerB());
        handleChain.addHandler(new HandlerC());
        handleChain.handle();
    }
}
