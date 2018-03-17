package com.javabase.concurrent.synchronizer.test023;

import javassist.runtime.Inner;

/**
 * @Author: wtshen
 * @Description: 即不用加锁, 也能实现懒加载
 * @Date: Created in 下午10:29 18/3/11.
 * @Modified By:
 */
public class Singleton1 {
    public Singleton1() {
        System.out.println("single");
    }

    private static class Inner {
        private static Singleton1 s = new Singleton1();
    }

    public static Singleton1 getSingleton() {
        return Inner.s;
    }

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getSingleton();
        Singleton1 singleton2 = Singleton1.getSingleton();
        System.out.println(singleton1 == singleton2);
    }
}
