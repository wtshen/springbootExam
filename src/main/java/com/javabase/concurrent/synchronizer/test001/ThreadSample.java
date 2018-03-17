package com.javabase.concurrent.synchronizer.test001;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 上午11:15 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    private int count = 10;
    private Object o = new Object();

    private void m() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count " + count);
        }
    }

    public static void main(String[] args){
        ThreadSample threadSample = new ThreadSample();
        threadSample.m();
    }
}
