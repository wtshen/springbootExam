package com.test.concurrent.test_001;

/**
 * Created by wtshen on 18/2/25.
 */
public class T {
    private int count = 10;
    private Object o = new Object();

    private void m() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count " + count);
        }
    }

    public static void main(String[] args){
        T t = new T();
        t.m();
    }
}
