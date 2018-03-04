package com.test.concurrent.test013;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: wtshen
 * @Description:
 * volatile 仅保证可见性,A线程修改完后为100,B C线程拿到100后,B++后得到101,写回主内存,C++后得到101,也写回主内存,这样就少加了1
 * synchronized 即保证可见性,也保证原子性
 * @Date: Created in 下午8:47 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    volatile int count;

    /*synchronized*/ void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSample threadSample = new ThreadSample();

        List<Thread> threadList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(threadSample::m, "thread" + i));
        }

        threadList.forEach((thread -> thread.start()));
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(threadSample.count);
    }
}
