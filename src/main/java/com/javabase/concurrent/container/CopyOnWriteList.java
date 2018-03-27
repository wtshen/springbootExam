package com.javabase.concurrent.container;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: wtshen
 * @Description: 写时复制容器
 * 多线程环境下,写时效率低,查询时效率高
 * 当新增或修改容器时,他会复制出一个新的容器,再将引用指向新容器,不需要加锁
 * 适用于写少读多的场景
 * @Date: Created in 下午8:56 18/3/27.
 * @Modified By:
 */
public class CopyOnWriteList {
    private static final Integer MAX_THREAD_COUNT = 100;
    private static final Integer MAX_ELEMENT_COUNT = 1000;

    public static void main(String[] args) {
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        Random random = new Random();
        Thread[] threads = new Thread[MAX_THREAD_COUNT];

        for (Integer i = 0; i < MAX_THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (Integer integer = 0; integer < MAX_ELEMENT_COUNT; integer++) {
                    copyOnWriteList.add("a" + random.nextInt(MAX_ELEMENT_COUNT));
                }
            });
        }

        runAndComputeTime(threads);
        System.out.println(copyOnWriteList.size());
    }

    private static void runAndComputeTime(Thread[] threads) {
        LocalDateTime start = LocalDateTime.now();
        Arrays.asList(threads).forEach(thread -> thread.start());
        Arrays.asList(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        LocalDateTime end = LocalDateTime.now();
        System.out.println("总耗时:" + Duration.between(start, end));
    }
}
