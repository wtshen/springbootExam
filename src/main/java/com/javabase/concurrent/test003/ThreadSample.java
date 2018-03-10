package com.javabase.concurrent.test003;

/**
 * @Author: wtshen
 * @Description: synchronized 关键字,对某个对象加锁
 * @Date: Created in 上午11:15 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    private int count = 10;

    private synchronized void m() { // 等同于在方法的代码执行时候要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }

    public static void main(String[] args){
        ThreadSample threadSample = new ThreadSample();
        threadSample.m();
    }
}
