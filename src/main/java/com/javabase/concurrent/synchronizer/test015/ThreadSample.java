package com.javabase.concurrent.synchronizer.test015;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wtshen
 * @Description: 解决同样问题更搞笑得方法, 使用ActomicXXX类
 * ActomicXXX类本身方法都是原子性的,但不能保证多个方法连续调用是原子性的
 * @Date: Created in 下午9:01 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i < 10000; i++) {
            // if (count.get()<1000) 和下面这句一起使用时候则不保证院子性
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSample threadSample = new ThreadSample();
        List<Thread> threadList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(threadSample::m, "thread" + i));
        }

        threadList.forEach(thread -> thread.start());
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(threadSample.count);
    }
}
