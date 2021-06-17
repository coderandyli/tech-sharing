package com.eports.java_locks.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: volatile 不能保证原子性
 * @Date 2021/6/17 2:35 下午
 * @Created by lizhenzhen
 */
public class VolatileTest03 {
    private static volatile int counter = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++)
                        counter++;
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
