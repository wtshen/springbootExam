package com.swt.concurrent.threadpool;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: wtshen
 * @Description:
 * 分支合并线程池(mapduce 类似设计思想), 使用于处理复杂任务
 * 初始化线程的线程的容量和 cpu 核心数有关
 * 线程池中运行内容必须是 ForkJoinTask 的子类型(RecursiveTask-有返回值,RecursiveAction-无返回值)
 * ForkJoinPool 没有所谓的容量,默认都是1个线程,根据任务自动的分支新的子线程,当子线程任务结束后,自动合并
 * 应用:主要是做科学计算,天文运算,数据分析
 * @Date: Created in 下午9:53 18/7/14.
 * @Modified By:
 */
public class ForkJoinPoolDemo {
    final static int[] numbers = new int[100000000];
    final static Integer MAX_SIZE = 5000;
    final static Random r = new Random();

    static {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(1000);
        }
    }

    static class AddTask extends RecursiveTask<Long> {
        int begin;
        int end;

        public AddTask(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }


        @Override
        protected Long compute() {
            if (end - begin < MAX_SIZE) {
                long sum = 0L;
                for (int i = begin; i < end; i++) {
                    sum += numbers[i];
                }
                return sum;
            } else {
                int middle = begin + (end - begin) / 2;
                AddTask task1 = new AddTask(begin, middle);
                AddTask task2 = new AddTask(middle, end);
                // 就是用于开启新的线程任务
                task1.fork();
                task2.fork();
                // join 合并.将任务的结果获取,这是一个阻塞方法,一定会得到结果数据
                return task1.join() + task2.join();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        LocalDateTime singleThreadNow = LocalDateTime.now();
        long result = 0L;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        System.out.println("result:" + result + ",耗时:" + Duration.between(singleThreadNow, LocalDateTime.now()).toMillis());

        LocalDateTime paralledNow = LocalDateTime.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AddTask addTask = new AddTask(0, numbers.length);

        Future<Long> future = forkJoinPool.submit(addTask);
        System.out.println("ForkJoinPool result:" + future.get() + ",耗时:" + Duration.between(paralledNow, LocalDateTime.now()).toMillis());
    }

}
