package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2;

import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2.impl.JDKInvocationHandlerImpl;
import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2.impl.OrderServiceImpl;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 4:19 PM 2020/4/4.
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        JavaClassLoader javaClassLoader = new JavaClassLoader();
        OrderService proxyInstant = (OrderService) MyProxy.newProxyInstant(javaClassLoader, OrderService.class, new JDKInvocationHandlerImpl(new OrderServiceImpl()));
        proxyInstant.service();
    }
}
