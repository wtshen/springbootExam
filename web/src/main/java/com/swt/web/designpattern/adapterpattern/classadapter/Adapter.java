package com.swt.web.designpattern.adapterpattern.classadapter;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:46 PM 2020/4/11.
 * @Modified By:
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void method2() {
        System.out.println(">>>Adapter method2");
    }

    @Override
    public void method1() {
        System.out.println("对代理者进行功能增强---Start");
        super.method1();
        System.out.println("对代理者进行功能增强---End");
    }
}
