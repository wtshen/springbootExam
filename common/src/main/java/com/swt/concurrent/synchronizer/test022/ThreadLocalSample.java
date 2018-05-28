package com.swt.concurrent.synchronizer.test022;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wtshen
 * @Description: ThreadLocal是使用空间换时间, synchronized使用时间换空间
 * 使用场景:DB Connection
 * 注意事项:因为使用的是弱引用,GC后会导致ThreadLocalMap中存在key为Null的Map,从而发生内存泄露,所以使用完之后需要remove
 * @Date: Created in 下午9:19 18/3/11.
 * @Modified By:
 */
public class ThreadLocalSample {

    public static void main(String[] args) {
        ThreadLocal<Person> personThreadLocal = new ThreadLocal<>();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(personThreadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                personThreadLocal.remove();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                personThreadLocal.set(new Person());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                personThreadLocal.remove();
            }
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}
