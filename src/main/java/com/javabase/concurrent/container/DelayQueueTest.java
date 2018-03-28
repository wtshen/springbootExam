package com.javabase.concurrent.container;

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
    class DelayedElement implements Delayed {
        /**
         * 延迟时间
         */
        private final long delayTime;
        /**
         * 到期时间
         */
        private final long expire;
        /**
         * 数据
         */
        private String data;

        public DelayedElement(long delay, String data) {
            delayTime = delay;
            this.data = data;
            expire = System.currentTimeMillis() + delay;
        }

        /**
         * 剩余时间=到期时间-当前时间
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /**
         * 优先队列里面优先级规则
         */
        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("DelayedElement{");
            sb.append("delay=").append(delayTime);
            sb.append(", expire=").append(expire);
            sb.append(", data='").append(data).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

        DelayQueueTest.DelayedElement element1 = new DelayQueueTest().new DelayedElement(3000, "zlx");
        DelayQueueTest.DelayedElement element2 = new DelayQueueTest().new DelayedElement(2000, "gh");

        delayQueue.offer(element1);
        delayQueue.offer(element2);

        while (true) {
            if (!delayQueue.isEmpty()) {
                System.out.println(delayQueue.take());
            }
        }
    }
}
