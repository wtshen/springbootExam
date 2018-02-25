package com.test.concurrent.test_005;

/**
 * Created by wtshen on 18/2/25.
 */
public class T implements Runnable {

    private int count = 10;

    // 如果不加synchronized,则输出是乱序的,或者--后依然是同一个数
    // 原因就是线程重入,一个线程还没有执行完,另一个线程又进入了将其打断,把没有打印的count又减了一次
    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 5; i++) {
            new Thread(t, "thread:" + i).start();
        }
    }
}
