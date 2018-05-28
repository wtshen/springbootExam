package com.swt.concurrent.container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午11:26 18/3/27.
 * @Modified By:
 */
public class ArrayBlockQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.put("a" + i);
        }

        // 报异常
        //tasks.add("a" + 1);

        // 不报错,但是加不进去
        queue.offer("a" + 1);

        // 满了就阻塞
        //tasks.put("a" + 1);

        System.out.println(queue);

    }
}
