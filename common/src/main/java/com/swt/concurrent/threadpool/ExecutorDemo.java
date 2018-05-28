package com.swt.concurrent.threadpool;


import java.util.concurrent.Executor;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 17:39 2018/4/3
 * @Modified By:
 */
public class ExecutorDemo implements Executor {
    @Override
    public void execute(Runnable command) {
        //command.run();
        new Thread(command).run();
    }

    public static void main(String[] args) {
        new ExecutorDemo().execute(() -> System.out.println("hello executor"));
    }
}
