package com.swt.concurrent.synchronizer.test019;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description:
 * 使用Latch门闩替代wait notify来进行通知,避免等待队列
 * 优点:通讯方式简单,同时也可以指定等待时间
 * 使用await和countdown来替代wait和notify
 * CountDownLatch不涉及锁定,当count值为0时当前线程继续运行
 * 当不涉及同步,只是涉及线程通信的时候,用synchronized+wait notify就显得太重了
 * 这是应该考虑countdownlatch/cyclicbarrier/semaphore
 * 使用场景:一个线程A等待其它线程都执行完毕后，这个线程A才继续执行
 * @Date: Created in 下午11:44 18/3/8.
 * @Modified By:
 */
public class CountdownlatchSample {
    volatile List lists = Lists.newArrayList();

    void add(Object o) {
        lists.add(o);
    }

    int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        CountdownlatchSample countdownlatchSample = new CountdownlatchSample();
        CountDownLatch lock = new CountDownLatch(1);

        Thread thread2 = new Thread(() -> {
            if (countdownlatchSample.size() != 5) {
                try {
                    lock.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " end");

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
                    countdownlatchSample.add(i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " add " + i);
                    if (countdownlatchSample.size() == 5) {
                        lock.countDown();
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
