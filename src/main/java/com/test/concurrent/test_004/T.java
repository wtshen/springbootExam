package com.test.concurrent.test_004;

/**
 * Created by wtshen on 18/2/25.
 */
public class T {
    private static int count = 10;

    // 等同于synchronized(test.concurrent.test_004.Account.class)
    private synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }

    public static void main(String[] args) {
        // 这里不能写成synchronized(this)
        // 静态属性或这方法没有this,因为不需要new
        synchronized (T.class) {
            count--;
        }
    }
}
