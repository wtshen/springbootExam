package com.swt.concurrent.synchronizer.test020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wtshen
 * @Description: ReentrantLock还可以指定为公平锁
 * @Date: Created in 下午10:36 18/3/10.
 * @Modified By:
 */
public class ReentrantLock5 extends Thread {
    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 reentrantLock5 = new ReentrantLock5();
        new Thread(reentrantLock5).start();
        new Thread(reentrantLock5).start();
    }
}
