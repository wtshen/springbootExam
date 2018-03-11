package com.javabase.concurrent.test021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @Author: wtshen
 * @Description: 使用Lock\Condition实现同步列表
 * Condition可以指定唤醒哪一个线程
 * @Date: Created in 下午5:12 18/3/11.
 * @Modified By:
 */
public class LockConfitionContainer<T> {
    private final LinkedList<T> lists = new LinkedList();
    private final static Integer MAX = 10;
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition comsumer = lock.newCondition();

    public void put(T t) {
        lock.lock();
        try {
            while (lists.size() == MAX) {
                // 生产者进入等待
                producer.await();
            }
            lists.add(t);
            // 通知消费者开始消费
            comsumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        lock.lock();
        T t = null;
        try {
            while (lists.size() == 0) {
                comsumer.await();
            }
            t = lists.removeFirst();
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        LockConfitionContainer<Integer> container = new LockConfitionContainer();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 5; i1++) {
                    Integer result = container.get();
                    System.out.println(Thread.currentThread().getName() + " comsumer " + result);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 25; i1++) {
                    container.put(i1);
                    System.out.println(Thread.currentThread().getName() + " producer " + i1);
                }
            }).start();
        }
    }
}
