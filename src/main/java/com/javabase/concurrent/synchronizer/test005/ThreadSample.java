package com.javabase.concurrent.synchronizer.test005;

/**
 * @Author: wtshen
 * @Description: synchronized 关键字,对某个对象加锁
 * @Date: Created in 上午11:15 18/3/4.
 * @Modified By:
 */
public class ThreadSample implements Runnable {

    private int count = 10;

    // 如果不加synchronized,则输出是乱序的,或者--后依然是同一个数
    // 原因就是线程重入,一个线程还没有执行完,另一个线程又进入了将其打断,把没有打印的count又减了一次
    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }

    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();
        for (int i = 0; i < 5; i++) {
            new Thread(threadSample, "thread:" + i).start();
        }
    }
}
