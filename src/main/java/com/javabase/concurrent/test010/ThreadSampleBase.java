package com.javabase.concurrent.test010;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description: 1.一个同步方法可以调用另外一个同步方法
 * 2.一个线程拥有了某个对象的锁,还可以再次获得该锁
 * 子类也可以调用父类的同步方法
 * @Date: Created in 下午4:12 18/3/4.
 * @Modified By:
 */
public class ThreadSampleBase {
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + ":m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":m end");
    }
}
