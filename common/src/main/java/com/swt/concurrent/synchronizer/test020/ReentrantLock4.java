package com.swt.concurrent.synchronizer.test020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wtshen
 * @Description: 使用ReentrantLock可以调用lockInterruptibly(), 可以对线程interrupt方法做出响应
 * 注意,只能解自己线程锁,不能解其他线程,打个比方:自己上厕所,完事后,不可能打开隔壁的门
 * @Date: Created in 下午10:20 18/3/10.
 * @Modified By:
 */
public class ReentrantLock4 {
    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        System.out.println("t1 start");
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            System.out.println("t1 end");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted!");
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        try {
            lock.lockInterruptibly();
            System.out.println("t2 start");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("t2 end");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted!");
        } finally {
            if (lock.tryLock()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock4 reentrantLock4 = new ReentrantLock4();
        Thread thread1 = new Thread(reentrantLock4::m1, "thread1");
        Thread thread2 = new Thread(reentrantLock4::m2, "thread2");

        thread1.start();
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.interrupt();
    }
}
