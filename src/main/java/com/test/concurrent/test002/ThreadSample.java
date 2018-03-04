package com.test.concurrent.test002;

/**
 * @Author: wtshen
 * @Description: synchronized 关键字,对某个对象加锁
 * @Date: Created in 上午11:15 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    private int count = 10;

    private void m() {
        // 任何线程要执行下面的代码,必需先拿到this的锁
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }

    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();
        threadSample.m();
    }
}
