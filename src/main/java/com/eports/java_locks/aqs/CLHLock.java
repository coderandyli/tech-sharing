package com.eports.java_locks.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * CLH自旋锁的实现
 *
 * <h3> 示例目的 <h3/>
 * 主要了解什么是自旋
 *
 * <h3> 概述 <h3/>
 * - CLH队列锁：是一个自旋锁，能确保无饥饿性，提供先来先服务的公平性。同时它也是一种基于链表的可扩展、高性能、公平的自旋锁，
 * 申请线程只在本地变量上自旋，它不断轮询前驱的状态，如果发现前驱释放了锁就结束自旋
 * - 这个算法很妙的点在于，在一个CAS操作帮助下，所有等待获取锁的线程之下的节点轻松且正确地构建成了全局队列。
 * 等待中的线程正如队列中的节点依次获取锁。
 * - 在前驱节点上自旋
 *
 * <h3> 数据结构 <h3/>
 * https://www.javazhiyin.com/wp-content/uploads/2020/08/java9-1598792426-1.png
 *
 * <h3> 扩展 <h3/>
 * - CLH 与 MCS 区别？
 * - CLH 为什么在前驱节点上自旋？而不再当前节点自旋
 *
 * <h3> Reference <h3/>
 * - https://stackoverflow.com/questions/43628187/why-clh-lock-need-prev-node-in-java
 * - https://www.javazhiyin.com/66571.html
 *
 * @Date 2021/6/18 5:19 下午
 * @Created by lizhenzhen
 */
public class CLHLock implements Lock {
    // 所有线程共享，总是指向最后一个节点（通过tail实现隐式链表）
    private final AtomicReference<QNode> tail;
    //当前节点的前驱节点，线程独有
    private final ThreadLocal<QNode> predNode;
    // 当前节点，线程独有
    private final ThreadLocal<QNode> currentNode;

    /**
     * Inner class
     */
    private static class QNode {
        // true if the lock has been acquired or is waiting to be acquired
        volatile boolean locked;
    }

    public CLHLock() {
        // 初始状态 tail指向一个新node(head)节点
        this.tail = new AtomicReference<>(new QNode());
        this.currentNode = ThreadLocal.withInitial(() -> new QNode());
        this.predNode = new ThreadLocal<>();
    }

    @Override
    public void lock() {
        // 将当前线程节点设置为tail,并将之前节点设置为前缀节点
        QNode node = currentNode.get();
        node.locked = true;
        QNode pred = tail.getAndSet(node);
        predNode.set(pred);

        // 自旋
        while (pred.locked) {
            System.out.println("线程" + Thread.currentThread().getName() + "没有获取锁，进行自旋等待");
        }
    }

    @Override
    public void unlock() {
        // 将当期线程节点设置为false
        QNode node = currentNode.get();
        node.locked = false;

        // 移除
        // currentNode.set(predNode.get());
        currentNode.set(new QNode());
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
        CLHLock myLock = new CLHLock();

        Runnable runnable = () -> {
            myLock.lock();

            int n = 10000;
            while (n > 0) {
                cnt++;
                n--;
            }

            myLock.unlock();
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        try {
            // 等待足够长的时间 确保上述线程均执行完毕
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cnt);
    }

}
