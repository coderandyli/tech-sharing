package com.eports.design_pattern.chain_of_responsibility.case01;

import com.eports.design_pattern.chain_of_responsibility.case01.handler.Handler;

/**
 * @description: 处理器链
 * @author: lizhenzhen
 * @date: 2021-04-20 17:22
 **/
public class HandleChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null){
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null){
            head.handle();
        }
    }
}
