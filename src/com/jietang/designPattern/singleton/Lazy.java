package com.jietang.designPattern.singleton;

/**
 * 方法2，懒汉模式 线程安全
 *  加锁影响效率
 */
public class Lazy {
    private static Lazy lazy;

    private Lazy() {
    }

    public synchronized static Lazy getInstance() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }
}
