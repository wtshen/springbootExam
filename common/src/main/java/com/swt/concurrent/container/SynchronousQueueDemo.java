package com.swt.concurrent.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午7:52 18/3/28.
 * @Modified By:
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 报错
        //queue.add("a1");

        // 阻塞,方法内部使用transfer
        queue.put("a1");
    }
}
