package com.javabase.concurrent.test015;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: wtshen
 * @Description: AtomicXXX可见性
 * @Date: Created in 下午10:41 18/3/5.
 * @Modified By:
 */
public class AtomicVisibility {
    AtomicBoolean isStop = new AtomicBoolean(true);

    void m() {
        System.out.println(Thread.currentThread().getName() + "-start");

        while (isStop.get()) {

        }

        System.out.println(Thread.currentThread().getName() + "-end");
    }

    public static void main(String[] args) {
        AtomicVisibility atomicVisibility = new AtomicVisibility();
        new Thread(atomicVisibility::m, "atomicThread").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicVisibility.isStop.set(false);

    }
}
