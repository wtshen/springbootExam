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
    public static void main(String[] args) {
        //Map<String,String> map = new ConcurrentHashMap<>();
        //Map<String,String> map = new ConcurrentSkipListMap<>();
        //Map<String,String> map = new HashMap<>();
        Map<String, String> map = new Hashtable<>();

        CountDownLatch latch = new CountDownLatch(100);
        Thread[] ths = new Thread[100];
        Random random = new Random();

        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    map.put("a" + random.nextInt(100000), "a" + random.nextInt(100000));
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
