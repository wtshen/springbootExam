package com.test.concurrent.test_002;

/**
 * synchronized 关键字
 * 对某个对象加锁
 * Created by wtshen on 18/2/25.
 */
public class T {
    private int count = 10;

    private void m() {
        synchronized (this) {// 任何线程要执行下面的代码,必需先拿到this的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }

    public static void main(String[] args) {
        T t = new T();
        t.m();
    }
}
