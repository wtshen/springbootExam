package com.swt.web.designpattern.adapterpattern;

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
        this.source.method1();
    }

    @Override
    public void method2() {
        System.out.println(">>>Adapter method2");
    }
}
