package com.swt.concurrent.synchronizer.test007;

/**
 * @Author: wtshen
 * @Description: 同步和非同步方法是否可以同时调用?
 * @Date: Created in 上午11:15 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
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
        ThreadSample threadSample = new ThreadSample();
        new Thread(threadSample::m1, "t1").start();
        new Thread(threadSample::m2, "t2").start();

        new Thread(() -> threadSample.m1(), "t3").start();
        new Thread(() -> threadSample.m2(), "t4").start();
    }
}
