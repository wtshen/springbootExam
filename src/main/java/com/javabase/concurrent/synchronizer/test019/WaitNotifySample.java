package com.javabase.concurrent.synchronizer.test019;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description: 使用wait和notify, wait会释放锁, 而notify不会
 * 1.wait和notify都是在对象上,想要使用必须先锁定该对象
 * 2.wait线程进入等待,只有通过对象上notify,才能继续执行
 * 3.使用notify无法指定通知的线程
 * 输出结果并不是size=5时t2退出,而是t1结束时t2才收到通知而退出,想想原因?
 * 因为notify不会释放锁,所以要t1执行完之后才会释放锁,t2才得以执行
 * @Date: Created in 下午11:05 18/3/8.
 * @Modified By:
 */
public class WaitNotifySample {
    volatile List lists = Lists.newArrayList();

    void add(Object o) {
        lists.add(o);
    }

    int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        WaitNotifySample waitNotifySample = new WaitNotifySample();
        final Object lock = new Object();

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                if (waitNotifySample.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 通知t1继续执行
                // lock.notify();
                System.out.println(Thread.currentThread().getName() + " end");
            }
        }, "t2");
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    waitNotifySample.add(i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " add " + i);
                    if (waitNotifySample.size() == 5) {
                        lock.notify();
                        // 加上这句会让t2得以执行,但是t1就会一直处于等待
                        // 除非配合t2线程的notify,再次通知后才能继续
                        /*try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }
                }
            }
        }, "t1");
        thread1.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getName() + "_" + thread1.getState());
        System.out.println(thread2.getName() + "_" + thread2.getState());
    }
}
