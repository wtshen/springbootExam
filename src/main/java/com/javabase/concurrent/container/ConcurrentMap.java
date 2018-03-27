package com.javabase.concurrent.container;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午8:56 18/3/18.
 * @Modified By:
 */
public class ConcurrentMap {
    private static final Integer MAX_THREAD_COUNT = 100;
    private static final Integer MAX_ELEMENT_COUNT = 10000;

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>(MAX_THREAD_COUNT * MAX_ELEMENT_COUNT);

        // 高并发并且排序,插入效率低,查询效率高
        //Map<String,String> map = new ConcurrentSkipListMap<>();

        //Map<String,String> map = new HashMap<>();

        //Map<String, String> map = new Hashtable<>();

        // 插入时效率低
        //TreeMap map = new TreeMap();

        CountDownLatch latch = new CountDownLatch(MAX_THREAD_COUNT);
        Thread[] ths = new Thread[MAX_THREAD_COUNT];
        Random random = new Random();

        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                for (int i1 = 0; i1 < MAX_ELEMENT_COUNT; i1++) {
                    map.put("a" + random.nextInt(MAX_ELEMENT_COUNT), "a" + random.nextInt(MAX_ELEMENT_COUNT));
                }
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach((t) -> t.start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(start, end));
    }
}
