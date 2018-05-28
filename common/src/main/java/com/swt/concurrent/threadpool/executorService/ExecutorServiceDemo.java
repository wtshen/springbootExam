package com.swt.concurrent.threadpool.executorService;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 19:14 2018/4/3
 * @Modified By:
 */
public class ExecutorServiceDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = Lists.newArrayList();
        // 创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));
            // 将任务执行结果存储到List中
            resultList.add(future);
        }
        executorService.shutdown();

        for (Future<String> future : resultList) {
            try {
                // 打印各个线程（任务）执行的结果
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
