package com.swt.aop.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:15 PM 2020/2/10.
 * @Modified By:
 */
public class TestCglib {
    public static void main(String[] args) {
        // Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
        Enhancer enhancer1 = new Enhancer();
        enhancer1.setSuperclass(TargetObject.class);
        enhancer1.setCallback(new TargetInterceptor());
        TargetObject targetObject1 = (TargetObject) enhancer1.create();

        System.out.println(targetObject1);
        System.out.println(targetObject1.method1("mmm1"));
        System.out.println(targetObject1.method2(100));
        System.out.println(targetObject1.method3(200));

        System.out.println("拦截器===============================");
        /**
         * (1)callback1：方法拦截器
         (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
         (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
         */
        Enhancer enhancer2 = new Enhancer();
        enhancer2.setSuperclass(TargetObject.class);
        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();
        Callback noopCb = NoOp.INSTANCE;
        Callback callback = new TargetInterceptor();
        Callback fixedValue = new TargetResultFixed();
        Callback[] cbArray = new Callback[]{callback, noopCb, fixedValue};
        enhancer2.setCallbacks(cbArray);
        enhancer2.setCallbackFilter(callbackFilter);
        TargetObject targetObject2 = (TargetObject) enhancer2.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(100));
        System.out.println(targetObject2.method3(200));
    }
}
