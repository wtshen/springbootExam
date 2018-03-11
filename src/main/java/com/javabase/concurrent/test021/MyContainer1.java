package com.javabase.concurrent.test021;

import com.javabase.collection.UserInfo;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description: 写一个固定容量同步容易, 拥有put和get方法, 以及getcount方法
 * 能够支持2个生产者以及10个消费者线程的阻塞调用
 * @Date: Created in 下午10:52 18/3/10.
 * @Modified By:
 */
public class MyContainer1<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private static Integer CONTAINER_MAX_COUNT = 10;

    synchronized void put(T t) {
        // 这里使用while的原因:
        // 一直需要检查是否是最大值,避免进入wait被唤醒后继续执行push时,其他线程已经往列表中加过值,导致list越界
        while (lists.size() == CONTAINER_MAX_COUNT) {
            try {
                // 释放锁
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.push(t);
        // 不用notify原因是可能又唤醒类生产者线程
        this.notifyAll();
    }

    synchronized T get() {
        T t = null;
        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();

        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer1<Integer> myContainer = new MyContainer1<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 5; i1++) {
                    Integer result = myContainer.get();
                    System.out.println(Thread.currentThread().getName() + " c " + result);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 25; i1++) {
                    myContainer.put(i1);
                    System.out.println(Thread.currentThread().getName() + " p " + i1);
                }
            }).start();
        }
    }
}
