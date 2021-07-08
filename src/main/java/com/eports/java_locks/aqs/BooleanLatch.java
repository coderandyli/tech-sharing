package com.eports.java_locks.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Date 2021/7/8 10:33 上午
 * @Created by lizhenzhen
 */
public class BooleanLatch {

    private static class Sync extends AbstractQueuedSynchronizer {
        boolean isSignalled() {
            return getState() != 0;
        }

        protected int tryAcquireShared(int ignore) {
            return isSignalled() ? 1 : -1;
        }

        protected boolean tryReleaseShared(int ignore) {
            setState(1);
            return true;
        }
    }

    private final Sync sync = new Sync();

    public boolean isSignalled() {
        return sync.isSignalled();
    }

    public void signal() {
        sync.releaseShared(1);
    }

    public void await() throws InterruptedException {
        // 加锁
        sync.acquireSharedInterruptibly(1);
    }

}
