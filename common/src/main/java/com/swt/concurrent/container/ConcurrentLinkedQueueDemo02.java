package com.swt.concurrent.container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午9:55 18/3/27.
 * @Modified By:
 */
public class ConcurrentLinkedQueueDemo02 {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            // 作用和add一样,但是可以通过返回值判断是否加成功
            queue.offer("a" + i);
        }

        System.out.println(queue);
        System.out.println(queue.size());

        System.out.println(queue.poll());
        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue.size());
    }

}
