package com.swt.web.designpattern.proxypattern.dynamicproxy.jdkproxy.impl;

import com.swt.web.designpattern.proxypattern.dynamicproxy.jdkproxy.OrderService;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:54 PM 2020/4/3.
 * @Modified By:
 */
public class OrderImpl implements OrderService {
    @Override
    public void service() {
        System.out.println("JDK Proxy Process...");
    }
}
