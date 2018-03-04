package com.test.concurrent.test009;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description:
 * 1.一个同步方法可以调用另外一个同步方法
 * 2.一个线程已经拥有某个对象的锁,再次申请的时候仍然会得到该对象的锁
 * 也就是说:synchronized获得的锁是可以重入的
 * @Date: Created in 上午11:15 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    /**
     *
     */
    synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + ":m1 start");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m2();
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ":m2 start");
    }

    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();
        new Thread(threadSample::m1, "m1-0").start();
        new Thread(() -> threadSample.m1(), "m1-1").start();
    }
}
