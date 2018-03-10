package com.javabase.concurrent.test010;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午4:16 18/3/4.
 * @Modified By:
 */
public class ThreadSampleSample extends ThreadSampleBase {
    @Override
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + ":" + this.getClass().getName() + "start");
        super.m();
        System.out.println(Thread.currentThread().getName() + ":" + this.getClass().getName() + "end");
    }

    public static void main(String[] args) {
        new ThreadSampleSample().m();
    }
}
