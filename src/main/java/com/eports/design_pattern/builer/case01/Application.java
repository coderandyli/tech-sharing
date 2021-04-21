package com.eports.design_pattern.builer.case01;

public class Application {

    public static void main(String[] args) {
        ResourcePoolConfig resourcePoolConfig = new ResourcePoolConfig.Builder()
                .setName("李振")
                .setMaxTotal(10)
                .setMaxIdle(10)
                .setMinIdle(9)
                .build();
        System.out.println(resourcePoolConfig);
    }
}
