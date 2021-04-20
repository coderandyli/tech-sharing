package com.eports.design_pattern.chain_of_responsibility.case02;

/**
 * @description: SensitiveWordFilter
 * @author: lizhenzhen
 * @date: 2021-04-20 17:10
 **/
public interface SensitiveWordFilter {
    boolean doFilter(String content);
}
