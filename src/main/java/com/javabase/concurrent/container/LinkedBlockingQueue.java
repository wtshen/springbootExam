package com.javabase.concurrent.container;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午10:54 18/3/27.
 * @Modified By:
 */
public class LinkedBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new java.util.concurrent.LinkedBlockingQueue<>();
        Random random = new Random();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    // 如果满了就会等待
                    queue.put("a" + i);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "--" + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
