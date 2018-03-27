package com.javabase.concurrent.container;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 上午11:56 18/3/17.
 * @Modified By:
 */
public class ConcurrentQueue {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票 编号" + i);
        }
    }

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        List<Thread> threadList = Lists.newArrayList();
        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(() -> {
                while (true) {
                    // 判断和操作分离时候,需要上锁
                    synchronized (lock) {
                        if (tickets.isEmpty()) {
                            break;
                        } else {
                            // poll 底层基于CAS实现
                            String ticket = tickets.poll();
                            count.incrementAndGet();
                            System.out.println(Thread.currentThread().getName() + "号窗口,销售了--" + ticket);

                        }
                    }
                }
            }));
        }

        threadList.forEach(thread -> thread.start());
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(count);
    }
}
