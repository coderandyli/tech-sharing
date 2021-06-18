package com.eports.java_locks.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * CLH自旋锁的实现
 * <p> Reference
 * - https://github.com/mrcharleshu/java-main/blob/master/src/main/java/com/charles/thread/CLHLockExample.java
 * - https://stackoverflow.com/questions/43628187/why-clh-lock-need-prev-node-in-java
 *
 * @Date 2021/6/18 5:19 下午
 * @Created by lizhenzhen
 */
public class CLHLock implements Lock {
    private final AtomicReference<QNode> tail;

    // why we need this node?
    private final ThreadLocal<QNode> myPred;

    private final ThreadLocal<QNode> myNode;

    public CLHLock() {
        // 初始状态 tail指向一个新node(head)节点
        this.tail = new AtomicReference<>(new QNode());
        this.myNode = new ThreadLocal() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
        this.myPred = new ThreadLocal<>();
    }

    @Override
    public void lock() {
        QNode node = myNode.get();
        node.locked = true;
        QNode pred = tail.getAndSet(node);

        // this.myPred == pred
        myPred.set(pred);
        while (pred.locked) {
        }
    }

    @Override
    public void unlock() {
        QNode node = myNode.get();
        node.locked = false;

        // this.myNode == this.myPred
        myNode.set(myPred.get());
    }

    private static class QNode {
        volatile boolean locked;
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
}
