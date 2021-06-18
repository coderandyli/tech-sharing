package com.eports.java_locks.volatiles;

/**
 * @Description: volatile在单例中的应用 - 禁止指令重（保证有序性）
 * @Date 2021/6/16 3:16 下午
 * @Created by lizhenzhen
 */
public class VolatileTest01 {

    /**
     *  如果instance没有被volatile修饰（禁止指令重拍），当{@link #getInstance()}方法中
     *   用instance==null的方法判断instance有没有被正确初始化的话，有可能会出现instance访问失败的情况。
     *   在这个时间点上，同步代码块尚未执行完毕，由于指令重排序，instance对象已经指向分配的内存空间，但是instance尚未初始化完毕。
     *   在这时调用instance，会引发jvm的exception。
     *
     *  对象instance创建过程
     *      a. 给 instance 分配内存
     *      b. 调用 Singleton03 的构造函数来初始化成员变量
     *      c. 将 instance 对象指向分配的内存空间（执行完这步 singleton 就为非 null 了）
     *  不加volatile关键字 b、c的执行顺序无法保证
     */
    private volatile static VolatileTest01 instance;

    private VolatileTest01() {
    }

    public static VolatileTest01 getInstance() {
        if (instance == null) {
            synchronized (VolatileTest01.class) {
                if (instance == null) {
                    instance = new VolatileTest01();
                }
            }
        }
        return instance;
    }

}
