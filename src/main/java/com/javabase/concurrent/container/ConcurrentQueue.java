package com.javabase.concurrent.container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

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
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String ticket = tickets.poll();
                    if (ticket == null) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "号窗口,销售了--" + ticket);
                }
            }).start();
        }
    }
}
