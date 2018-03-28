package com.javabase.concurrent.container;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description: 1.LinkedTransferQueue实际上是ConcurrentLinkedQueue、SynchronousQueue（公平模式）和LinkedBlockingQueue的超集。
 * 而且LinkedTransferQueue更好用，因为它不仅仅综合了这几个类的功能，同时也提供了更高效的实现。
 * 2.当我们不想生产者过度生产消息时，TransferQueue可能非常有用，因为没有消费者时队列就阻塞,不会继续生产,
 * 可避免发生OutOfMemory错误。在这样的设计中，消费者的消费能力将决定生产者产生消息的速度。
 * @Date: Created in 下午7:33 18/3/28.
 * @Modified By:
 */
public class LinkedTransferQueueDemo {
    static LinkedTransferQueue<String> lnkTransQueue = new LinkedTransferQueue<>();

    public static void main(String[] args) {
        ExecutorService exService = Executors.newFixedThreadPool(2);
        Producer producer = new LinkedTransferQueueDemo().new Producer();
        Consumer consumer = new LinkedTransferQueueDemo().new Consumer();
        exService.execute(producer);
        exService.execute(consumer);
        exService.shutdown();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("Producer is waiting to transfer...");
                    lnkTransQueue.transfer("A" + i);
                    System.out.println("producer transfered element: A" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("Consumer is waiting to take element...");
                    String s = lnkTransQueue.take();
                    System.out.println("Consumer received Element: " + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
