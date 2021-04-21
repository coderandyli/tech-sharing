package com.eports.design_pattern.template_pattern.case03;

/**
 * @description: 基于回调函数实现的模板方法模式
 * @author: lizhenzhen
 * @date: 2021-04-21 15:57
 **/
public class Application {
    public static void main(String[] args) {
        AClass aClass = new AClass();
        aClass.process(new ICallBack() {
            @Override
            public void methodToCallback() {
                System.out.println("执行完成之后回调");
            }
        });
    }
}
