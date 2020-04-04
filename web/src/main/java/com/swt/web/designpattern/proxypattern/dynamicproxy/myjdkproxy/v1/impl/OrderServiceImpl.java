package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v1.impl;

import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v1.OrderService;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 4:02 PM 2020/4/4.
 * @Modified By:
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void service() {
        System.out.println("My JDK Proxy Process...");
    }
}
