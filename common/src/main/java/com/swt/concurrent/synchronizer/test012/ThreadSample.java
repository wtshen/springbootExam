package com.swt.concurrent.synchronizer.test012;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description: volatile 关键字,是一个变量在多个线程中可见
 * A B 线程都用到一个变量,java默认是A线程中保留一份copy,如果B线程修改该变量后,则A线程未必知道
 * 使用volatile关键字,会强制所有线程都去堆内存中读取值
 * @Date: Created in 下午6:31 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    /*volatile*/ boolean isRunning = true;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (isRunning) {
            // 如果在此处有一些长时间执行的代码,那么可能在某一时刻又从主内存中获取到false值
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }

    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();
        new Thread(threadSample::m, "thread1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadSample.isRunning = false;
    }
}
