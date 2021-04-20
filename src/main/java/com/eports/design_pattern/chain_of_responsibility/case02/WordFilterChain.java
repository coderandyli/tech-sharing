package com.eports.design_pattern.chain_of_responsibility.case02;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 过滤器链
 * @author: lizhenzhen
 * @date: 2021-04-20 17:14
 **/
public class WordFilterChain {
    private List<SensitiveWordFilter> wordFilters = new ArrayList<>();

    public void addwordFilter(SensitiveWordFilter wordFilter) {
        wordFilters.add(wordFilter);
    }

    public void doFilter(String content) {
        boolean legal = false;
        for (SensitiveWordFilter wordFilter : wordFilters) {
            legal = wordFilter.doFilter(content);
            if (!legal) {
                break;
            }
        }
        if (legal) {
            System.out.println("可以发布");
        } else {
            System.out.println("文章含有敏感词汇，禁止发布");
        }
    }
}
