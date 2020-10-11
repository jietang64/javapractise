package com.jietang.designPattern.singleton;

/**
 * 方法2，饿汉模式，线程安全
 * 但是没有懒加载，会浪费内存
 */
public class Hungry {
    private static Hungry hungry = new Hungry();
    private Hungry() {
    }

    public static Hungry getInstance() {
       return hungry;
    }
}
