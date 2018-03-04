package com.test.concurrent.test011;

import org.hibernate.annotations.SourceType;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description: 程序的处理过程中, 如果出现异常, 那么锁会被释放
 * 所以,在处理并发的过程中,有异常要当心,不然可能发生不一致的情况
 * 比如,在一个web app处理过程中,多个servlet线程功能访问同一个资源,这时如果异常处理不当
 * 在第一个线程中抛出一场,其他线程就会进入同步代码区,可能会访问到异常产生的数据
 * 因此要非常小心的处理同步业务逻辑中的异常
 * @Date: Created in 下午4:29 18/3/4.
 * @Modified By:
 */
public class ThreadSample {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count=" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
                // 如果放在异常处理中,则其他线程则无法获取到该锁,无法继续执行
                // 线程状态可观察main中输出
                if (count == 5) {
                    int i = 1 / 0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }
            /*if (count == 5) {
                int i = 1 / 0;
            }*/
        }
    }

    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();
        Thread thread1 = new Thread(threadSample::m, "Thread1");
        thread1.start();

        Thread thread2 = new Thread(threadSample::m, "Thread2");
        thread2.start();

        // 输出线程的状态
        while (true) {
            System.out.println("thread1 state:" + thread1.getState());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 state" + ":" + thread2.getState());
        }
    }
}
