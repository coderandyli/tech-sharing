package com.eports.design_pattern.template_pattern.case02;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 16:25
 **/
public class Application {
    static int count = 0;

    public static void main(String[] args) {
        MyLockBaseAqs myLock = new MyLockBaseAqs();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myLock.lock(); // 加锁

                int n = 10000;
                while (n > 0) {
                    count++;
                    n--;
                }

                myLock.unlock(); // 释放锁
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        try {
            //等待足够长的时间 确保上述线程均执行完毕
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
