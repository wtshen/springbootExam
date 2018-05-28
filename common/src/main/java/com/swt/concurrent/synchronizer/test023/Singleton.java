package com.swt.concurrent.synchronizer.test023;

/**
 * @Author: wtshen
 * @Description: 即不用加锁, 也能实现懒加载
 * 内部类介绍:
 * 1.内部类提供了更好的封装,只有外部类可以访问内部类
 * 2.内部类可以独立继承接口,不受外部类是否继承接口的影响
 * 3.外部类不能直接访问内部类的属性和方法,内部类可以访问外部类的属性和方法
 * 4.利用回调函数的调用
 * @Date: Created in 下午10:29 18/3/11.
 * @Modified By:
 */
public class Singleton {
    private static class Inner{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton(){
        return Inner.singleton;
    }

    public Singleton() {
        System.out.println("create singleton");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton == singleton2);
    }
}
