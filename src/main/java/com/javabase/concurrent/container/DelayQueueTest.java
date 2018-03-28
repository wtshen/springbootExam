package com.javabase.concurrent.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 上午8:02 18/3/28.
 * @Modified By:
 */
public class DelayQueueTest {
    static BlockingQueue<MyTask> tasks = new DelayQueue();

    static class MyTask implements Delayed {
        long runningTime;

        public MyTask(long runningTime) {
            this.runningTime = runningTime;
        }

        /**
         * 出队时间
         *
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /**
         * 比较队列中任务顺序
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "" + runningTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask myTask1 = new MyTask(now + 1000);
        MyTask myTask2 = new MyTask(now + 2000);
        MyTask myTask3 = new MyTask(now + 1500);
        MyTask myTask4 = new MyTask(now + 2500);
        MyTask myTask5 = new MyTask(now + 500);

        tasks.put(myTask1);
        tasks.put(myTask2);
        tasks.put(myTask3);
        tasks.put(myTask4);
        tasks.put(myTask5);

        System.out.println(tasks);

        for (int i = 0; i < 5; i++) {
            System.out.println(tasks.take());
        }

    }
}
