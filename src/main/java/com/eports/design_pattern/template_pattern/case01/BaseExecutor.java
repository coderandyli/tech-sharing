package com.eports.design_pattern.template_pattern.case01;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 16:09
 **/
public abstract class BaseExecutor {

    public int update(String ms){
       System.out.println("参数合法性校验、清除缓存....");
        return doUpdate(ms);
    }

    public abstract int doUpdate(String ms);
}
