package com.javabase.concurrent.test019;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description: 实现一个容易, 提供两个方法, add size
 * 写两个线程,线程1添加10个元素到容器中,线程2实现监控元素的个数,当个数到5的时候,线程2给出提示并结束
 *
 * 给lists添加volatile后,t2能够接到通知,但是,t2线程的死循环很浪费cpu
 * @Date: Created in 下午11:07 18/3/7.
 * @Modified By:
 */
public class MyContainer1 {
    volatile List lists = Lists.newArrayList();


    void add(Object o) {
        lists.add(o);
    }

    int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        MyContainer1 myContainer1 = new MyContainer1();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myContainer1.add(i);
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (myContainer1.size() == 5) {
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + " end");
        }, "t2").start();

    }
}
