package com.test.concurrent.test009;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午12:01 18/3/4.
 * @Modified By:
 */
public class ThreadDeadLockSample {
    Object o1 = new Object();
    Object o2 = new Object();

    void m1() {
        while (true) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + ":m1 lock o1 start");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + ":m1 lock o2 start");

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    void m2() {
        while (true) {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + ":m2 lock o2 start");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + ":m2 lock o1 start");

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDeadLockSample threadDeadLockSample = new ThreadDeadLockSample();
        // 主线程运行没问题,因为是顺序执行
        //threadDeadLockSample.m1();
        //threadDeadLockSample.m2();

        // 多线程运行时产生死锁
        new Thread(threadDeadLockSample::m1, "thread1").start();
        new Thread(threadDeadLockSample::m2, "thread2").start();
    }
}
