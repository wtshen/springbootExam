package com.swt.jvm.gc;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 8:38 AM 2020/5/5.
 * @Modified By:
 */
public class GCDemo {
    private Object instance;

    public GCDemo() {
        byte[] m = new byte[20 * 1024 * 1024];
    }

    public static void main(String[] args) {
        GCDemo m1 = new GCDemo();
        GCDemo m2 = new GCDemo();

        m1.instance = m2;
        m2.instance = m1;

        m1 = null;
        m2 = null;

        System.gc();
    }

}
