package com.swt.jvm.deadlock;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:25 PM 2020/5/16.
 * @Modified By:
 */
public class DeadLockDemo implements Runnable {
    private Object obj1;
    private Object obj2;

    public DeadLockDemo(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (obj1) {
            System.out.println(threadName + "acquired lock on " + obj1);
            work();
            synchronized (obj2) {
                System.out.println("After," + threadName + "acquired lock on " + obj2);
                work();
            }
            System.out.println(threadName + " released lock on " + obj2);
        }
        System.out.println(threadName + " released lock on " + obj1);
        System.out.println(threadName + " finished execution.");
    }

    private void work() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new DeadLockDemo(obj1, obj2), "t1");
        Thread t2 = new Thread(new DeadLockDemo(obj2, obj3), "t2");
        Thread t3 = new Thread(new DeadLockDemo(obj3, obj1), "t3");

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();
    }
}
