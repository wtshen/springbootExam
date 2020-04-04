package com.swt.web.designpattern.proxypattern.dynamicproxy.cglibproxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:14 PM 2020/4/3.
 * @Modified By:
 */
public class OrderServiceProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib Proxy start...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLib Proxy end...");
        return result;
    }
}
