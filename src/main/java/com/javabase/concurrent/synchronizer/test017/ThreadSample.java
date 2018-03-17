package com.javabase.concurrent.synchronizer.test017;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description:
 * 锁定某对象o,如果对象属性发生变化,不影响锁的使用
 * 但如果o变成了另外一个对象,则锁定的对象发生改变,所以要避免将锁定对象的引用变成另外的对象
 * @Date: Created in 下午11:02 18/3/5.
 * @Modified By:
 */
public class ThreadSample {
    Object o = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();

        new Thread(threadSample::m,"thread1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //threadSample.o = new Object();
        new Thread(threadSample::m,"thread2").start();

    }
}
