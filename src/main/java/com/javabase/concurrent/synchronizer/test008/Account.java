package com.javabase.concurrent.synchronizer.test008;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description:
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题(dirtyRead)
 * @Date: Created in 上午11:15 18/3/4.
 * @Modified By:
 */
public class Account {
    private String name;
    private double balance;

    private synchronized void set(String name, double balance) {
        this.name = name;

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;

        System.out.printf("set accout name=%s balance=%s%n", this.name, this.balance);
    }

    // 解决方法就是get方法也加上 synchronized
    // 因为读写方法锁定同一对象,必须要等写的锁释放后,才能够获取锁进行读操作
    private /*synchronized*/ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(() -> account.set("zhangsan", 100.0), "ThreadSampleSample Set ").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zhangsan"));
    }
}
