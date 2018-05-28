package com.swt.concurrent.synchronizer.test020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wtshen
 * @Description:
 * ReentrantLock可以替代synchronized
 * 但是要注意:ReentrantLock必须要手工释放锁
 * 1.使用synchronized,遇到异常时,jvm会自动释放锁
 * 2.使用ReentrantLock必须手工释放锁,一般放到finally中
 * 使用ReentrantLock可以进行"尝试锁定"tryLock(),或者在指定时间内无法锁定,线程可以决定是否继续等待
 * @Date: Created in 下午7:56 18/3/10.
 * @Modified By:
 */
public class ReentrantLock3 {
    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1..." + i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 使用tryLock进行尝试锁定,不管锁定与否,方法都将继续执行
     * 可以根据tryLock的返回值判定是否锁定
     * 也可以指定tryLock的时间,由于tryLock(time)抛出异常,所以注意unlock的处理
     */
    void m2() {
        boolean isLock = lock.tryLock();
        if (isLock) {
            // doSomeThing
            System.out.println("m2...ock state:" + isLock);
            lock.unlock();
        } else {
            // doSomeThing
            System.out.println("m2...lock state:" + isLock);
        }
    }

    void m3() {
        boolean isLock = false;
        try {
            isLock = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m3...lock state:" + isLock);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (isLock) {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock3 reentrantLock3 = new ReentrantLock3();
        new Thread(reentrantLock3::m1).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(reentrantLock3::m2).start();
        new Thread(reentrantLock3::m3).start();

    }
}
