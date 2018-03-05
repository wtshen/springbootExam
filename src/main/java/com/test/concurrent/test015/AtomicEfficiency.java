package com.test.concurrent.test015;

import com.google.common.collect.Lists;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wtshen
 * @Description: 实践下AtomicXXX和synchronized两者性能高低
 * 据说AtomicXXX比synchronize性能高,但从结果上看正相反
 * @Date: Created in 下午10:13 18/3/5.
 * @Modified By:
 */
public class AtomicEfficiency {

    void atomicMethod() {
        LocalDateTime start = LocalDateTime.now();
        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 1000000; i++) {
            count.incrementAndGet();
        }
        Duration duration = Duration.between(start, LocalDateTime.now());
        System.out.printf("atomicMethod:加到%d,耗时%d毫秒%n", count.get(), duration.toMillis());
    }

    synchronized void synchronizedMethod() {
        LocalDateTime start = LocalDateTime.now();
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
        Duration duration = Duration.between(start, LocalDateTime.now());
        System.out.printf("synchronizedMethod:加到%d,耗时%d毫秒%n", count, duration.toMillis());
    }

    public static void main(String[] args) {
        AtomicEfficiency atomicEfficiency = new AtomicEfficiency();
        //atomicEfficiency.atomicMethod();
        //atomicEfficiency.synchronizedMethod();


        LocalDateTime atomicStart = LocalDateTime.now();
        List<Thread> atomicThreadList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            atomicThreadList.add(new Thread(atomicEfficiency::atomicMethod, "atomicThread" + i));
        }
        atomicThreadList.forEach(thread -> thread.start());
        atomicThreadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("atomicInteger多线程时总耗时:" + Duration.between(atomicStart, LocalDateTime.now()).toMillis());

        LocalDateTime synchronizedStart = LocalDateTime.now();
        List<Thread> synchronizedThreadList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            synchronizedThreadList.add(new Thread(atomicEfficiency::synchronizedMethod, "synchronizedThread" + i));
        }
        synchronizedThreadList.forEach(thread -> thread.start());
        synchronizedThreadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("synchronize多线程时总耗时:" + Duration.between(synchronizedStart, LocalDateTime.now()).toMillis());
    }
}
