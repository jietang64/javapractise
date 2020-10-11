package com.jietang.designPattern.singleton;

public class DoubleCheck {
    private static volatile DoubleCheck doubleCheck;

    public DoubleCheck() {
    }

    private static DoubleCheck getInstance() {
        if (doubleCheck == null) {
            // 懒汉模式中 synchronized存在大量的开销，所以先判断是否为空
            synchronized (DoubleCheck.class) {
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }
}
