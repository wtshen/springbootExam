package com.test.concurrent.test_006;

/**
 * 同步和非同步方法是否可以同时调用?
 * Created by wtshen on 18/2/25.
 */
public class T {
    private synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " m1 end...");
    }

    private void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " m2 end...");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();

        new Thread(() -> t.m1(), "t3").start();
        new Thread(() -> t.m2(), "t4").start();
    }
}
