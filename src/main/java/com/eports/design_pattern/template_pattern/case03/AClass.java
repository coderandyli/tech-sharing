package com.eports.design_pattern.template_pattern.case03;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 15:55
 **/
public class AClass {
    public void process(ICallBack callBack){
        System.out.println("执行BClass#process方法....");
        callBack.methodToCallback();
    }
}
