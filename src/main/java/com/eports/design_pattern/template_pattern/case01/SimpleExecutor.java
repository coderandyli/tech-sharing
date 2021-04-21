package com.eports.design_pattern.template_pattern.case01;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 16:16
 **/
public class SimpleExecutor extends BaseExecutor{

    @Override
    public int doUpdate(String ms) {
        System.out.println("执行更新逻辑... ");
        System.out.println(ms);
        return 1;
    }
}
