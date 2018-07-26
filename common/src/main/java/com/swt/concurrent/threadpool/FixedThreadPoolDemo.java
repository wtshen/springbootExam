package com.swt.concurrent.threadpool;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: wtshen
 * @Description: 固定容量线程池
 * FixedThreadPool - 固定容量线程池,创建线程池的时候,容量固定
 * 构造的时候,提供线程池最大容量
 * ExecutorService - 线程池服务类型,所有线程池类型都实现这个接口,实现这个接口,代表可以提供线程池能力
 * shutdown - 优雅关闭,不是强行关闭线程,回收线程池中的资源.而是不再处理新的任务,将已接收的任务处理完毕后再关闭
 * Executors - Executor的工具类.类似Collection和Collections的关系
 * @Date: Created in 下午9:40 18/4/3.
 * @Modified By:
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        // 不使用这种方式创建线程,堆积的请求队列会导致OOM
        //ExecutorService service = Executors.newFixedThreadPool(5);

        // 获取处理器数量
        int cpuNum = Runtime.getRuntime().availableProcessors();

        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        // 使用 ThreadPoolExecutor来模拟 FixedThreadPool
        // corePoolSize 线程池保持的最小线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
        // maximumPoolSize 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
        // keepAliveTime 非核心线程的闲置超时时间，超过这个时间就会被回收,0代表永久。
        // unit 指定keepAliveTime的单位，如TimeUnit.SECONDS。当将allowCoreThreadTimeOut设置为true时对corePoolSize生效。
        // workQueue 线程池中的任务队列.常用的有三种队列，SynchronousQueue,LinkedBlockingDeque,ArrayBlockingQueue。
        // threadFactory 线程工厂，提供创建新线程的功能。ThreadFactory是一个接口，只有一个方法

        // 如果是CPU密集型任务，那么线程池的线程个数应该尽量少一些，一般为CPU的个数+1条线程
        // 如果是IO密集型任务，那么线程池的线程可以放的很大，如2*CPU的个数
        ExecutorService service = new ThreadPoolExecutor(
                cpuNum * 2 + 1,
                cpuNum * 2 + 1,
                0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(1024),
                nameThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 6; i++) {
            final int finalI = i;
            service.execute(() -> {
                try {
                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task" + finalI + "-" + Thread.currentThread().getName() + " - test Executor");
            });
        }

        System.out.println(service);

        service.shutdown();
        // 是否已经结束,相当于回收了资源
        System.out.println("isShutdown:" + service.isShutdown());
        // 是否已经关闭,是否掉用过shutdown方法
        System.out.println("isTerminated:" + service.isTerminated());
        System.out.println(service);

        // 加上这段,执行则会报:java.util.concurrent.RejectedExecutionException
        /*service.execute(() -> {
            System.out.println("other task" + Thread.currentThread().getName());
        });*/

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
        System.out.println("isShutdown:" + service.isShutdown());
        System.out.println("isTerminated:" + service.isTerminated());
        System.out.println(service);
    }


}
