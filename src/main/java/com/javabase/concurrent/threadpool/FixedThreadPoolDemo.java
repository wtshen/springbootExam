package com.javabase.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午9:40 18/4/3.
 * @Modified By:
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);

        service.shutdown();
        System.out.println("service.isTerminated():" + service.isTerminated());
        System.out.println("service.isShutdown():"+service.isShutdown());
        System.out.println(service);

        TimeUnit.SECONDS.sleep(5);

        System.out.println("service.isTerminated():" + service.isTerminated());
        System.out.println("service.isShutdown():"+service.isShutdown());
        System.out.println(service);
    }
}
