package com.eports.java_locks.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于AQS实现的锁
 *
 * AQS加锁/解锁过程解析
 *
 *
 *
 * @Date 2021/6/17 3:32 下午
 * @Created by lizhenzhen
 */
public class LockBasedOnAqs implements Lock {
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
                // 设置当前现成独占访问权限（当期线程获取锁）
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

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }

    static int cnt = 0;
    public static void main(String[] args) {
        LockBasedOnAqs lock = new LockBasedOnAqs();

        Runnable runnable = () -> {
            lock.lock();

            int n = 10000;
            while (n > 0) {
                cnt++;
                n--;
            }

            lock.unlock();
        };

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
        System.out.println(cnt);
    }
}
