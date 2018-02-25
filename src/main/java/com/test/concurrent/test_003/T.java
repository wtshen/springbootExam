package com.test.concurrent.test_003;

/**
 * Created by wtshen on 18/2/25.
 */
public class T {
    private int count = 10;

    private synchronized void m() { // 等同于在方法的代码执行时候要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " + count);
    }

    public static void main(String[] args){
        T t = new T();
        t.m();
    }
}
