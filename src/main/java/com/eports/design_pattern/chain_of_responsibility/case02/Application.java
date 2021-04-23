package com.eports.design_pattern.chain_of_responsibility.case02;

import com.eports.design_pattern.chain_of_responsibility.case02.filter.AdsWordFilter;
import com.eports.design_pattern.chain_of_responsibility.case02.filter.PoliticalWordFilter;
import com.eports.design_pattern.chain_of_responsibility.case02.filter.SexyWordFilter;

/**
 * @description: 启动类
 * @author: lizhenzhen
 * @date: 2021-04-20 17:09
 **/
public class Application {
    public static void main(String[] args) {
        WordFilterChain filterChain = new WordFilterChain();
        filterChain.addwordFilter(new AdsWordFilter());
        filterChain.addwordFilter(new PoliticalWordFilter());
        filterChain.addwordFilter(new SexyWordFilter());
        
        filterChain.doFilter("金三胖统治下的朝鲜人民军所向披靡");
        System.out.println("------------------------------------------------");
        filterChain.doFilter("this is a healthy message");
    }
}
