package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2.impl;

import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2.JDKInvocationHandlerService;

import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 3:58 PM 2020/4/4.
 * @Modified By:
 */
public class JDKInvocationHandlerImpl implements JDKInvocationHandlerService {
    /**
     * 目标对象 被代理的类 真实访问的类的对象
     */
    Object target;

    public JDKInvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("纯手写 jdk 动态代理开始...");
        // 使用 java 的反射执行
        Object result = method.invoke(target, args);
        System.out.println("纯手写 jdk 动态代理结束...");
        return result;
    }
}
