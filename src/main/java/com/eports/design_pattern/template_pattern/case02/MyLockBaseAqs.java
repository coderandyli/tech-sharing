package com.eports.design_pattern.template_pattern.case02;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2021/4/19 下午11:20
 * <p>
 * 基于AQS自定义锁
 */
public class MyLockBaseAqs {
    /**
     * 同步器
     */
    private Sync sync = new Sync();

    /**
     * Inner class
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                // Sets the thread that currently owns exclusive access.
                // 设置当前现成独占访问权限
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    /**
     * 加锁
     */
    public void lock() {
        sync.acquire(1);
    }

    /**
     * 解锁
     */
    public void unlock() {
        sync.release(1);
    }
}
