package com.eports.design_pattern.chain_of_responsibility.case01.handler;

/**
 * @description: 处理器抽象类
 * @author: lizhenzhen
 * @date: 2021-04-20 17:18
 **/
public abstract class Handler {
    /**
     * 后继节点
     */
    Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void handle(){
        boolean handled = doHandle();
        if (!handled && successor != null){
            successor.handle();
        }
    }

    /**
     * 抽象方法，子类实现
     *  - 【模板模式】的体现
     */
    public abstract boolean doHandle();
}
