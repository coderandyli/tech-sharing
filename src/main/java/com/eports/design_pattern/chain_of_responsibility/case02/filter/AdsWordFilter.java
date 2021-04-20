package com.eports.design_pattern.chain_of_responsibility.case02.filter;

import com.eports.design_pattern.chain_of_responsibility.case02.SensitiveWordFilter;

/**
 * @description: 广告过滤器
 * @author: lizhenzhen
 * @date: 2021-04-20 17:11
 **/
public class AdsWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(String content) {
        boolean legal = true;
        legal = !content.contains("ads");
        return legal;
    }
}
