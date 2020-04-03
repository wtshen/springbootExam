package com.swt.web.designpattern.proxypattern.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:53 PM 2020/4/3.
 * @Modified By:
 */
public class ProxyFactroy {
    Object target;

    public ProxyFactroy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Object proxyObject = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("JDK Proxy start...");
            Object result = method.invoke(target, args);
            System.out.println("JDK Proxy end...");
            return result;
        });
        return proxyObject;
    }
}
