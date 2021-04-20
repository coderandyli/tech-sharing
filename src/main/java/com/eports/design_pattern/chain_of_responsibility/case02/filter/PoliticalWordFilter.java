package com.eports.design_pattern.chain_of_responsibility.case02.filter;

import com.eports.design_pattern.chain_of_responsibility.case02.SensitiveWordFilter;

/**
 * @description: 法规过滤器
 * @author: lizhenzhen
 * @date: 2021-04-20 17:12
 **/
public class PoliticalWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(String content) {
        boolean legal = true;
        legal = !content.contains("金三胖");
        return legal;
    }
}
