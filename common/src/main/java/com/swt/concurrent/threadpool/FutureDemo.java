package com.swt.concurrent.threadpool;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午9:52 18/4/3.
 * @Modified By:
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futureList = Lists.newArrayList();
        for (Integer i = 0; i < 6; i++) {
            final Integer finalI = i;
            Future<Integer> future = service.submit(() -> {
                TimeUnit.MILLISECONDS.sleep(500);
                return finalI;
            });
            futureList.add(future);
        }
        for (Future<Integer> future : futureList) {
            System.out.println(future.get());
        }
    }
}
