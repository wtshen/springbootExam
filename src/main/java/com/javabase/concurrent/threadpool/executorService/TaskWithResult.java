package com.javabase.concurrent.threadpool.executorService;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Author: wtshen
 * @Description: 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
 * @Date: Created in 19:18 2018/4/3
 * @Modified By:
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call(方法被自动调用，干活)" + Thread.currentThread().getName());
        if (new Random().nextBoolean()) {
            throw new TaskException("Meet error in task" + Thread.currentThread().getName());
        }
        for (int i = 999999999; i > 0; i--){}
        return "call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName();
    }
}
