package com.swt.web.designpattern.adapterpattern.objectadapter;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:29 PM 2020/4/11.
 * @Modified By:
 */
public class Adapter implements Target {
    Adaptee source;

    public Adapter(Adaptee source) {
        this.source = source;
    }

    @Override
    public void method1() {
        System.out.println("对代理者进行功能增强---Start");
        this.source.method1();
        System.out.println("对代理者进行功能增强---End");
    }

    @Override
    public void method2() {
        System.out.println(">>>Adapter method2");
    }
}
