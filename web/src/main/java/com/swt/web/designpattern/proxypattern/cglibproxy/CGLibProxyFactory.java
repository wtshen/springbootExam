package com.swt.web.designpattern.proxypattern.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:13 PM 2020/4/3.
 * @Modified By:
 */
public class CGLibProxyFactory {
    Object target;

    public CGLibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new OrderServiceProxy());
        Object proxy = enhancer.create();
        return proxy;
    }
}
