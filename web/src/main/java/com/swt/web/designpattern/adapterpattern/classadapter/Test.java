package com.swt.web.designpattern.adapterpattern.classadapter;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:48 PM 2020/4/11.
 * @Modified By:
 */
public class Test {
    public static void main(String[] args){
        Target target = new Adapter();
        target.method1();
        target.method2();
    }
}
