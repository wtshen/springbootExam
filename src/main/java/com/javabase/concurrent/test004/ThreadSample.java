package com.javabase.concurrent.test004;

/**
 * @Author: wtshen
 * @Description: synchronized 关键字,对某个对象加锁
 * @Date: Created in 上午11:15 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    private static int count = 10;

    /**
     * 等同于synchronized(javabase.concurrent.test004.Account.class)
     */
    private synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }

    public static void main(String[] args) {
        // 这里不能写成synchronized(this)
        // 静态属性或这方法没有this,因为不需要new
        synchronized (ThreadSample.class) {
            count--;
        }
    }
}
