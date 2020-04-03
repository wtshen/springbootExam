package com.swt.web.designpattern.proxypattern.jdkproxy;

import com.swt.web.designpattern.proxypattern.jdkproxy.impl.OrderImpl;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:00 PM 2020/4/3.
 * @Modified By:
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        OrderService orderService = new OrderImpl();
        OrderService orderServiceProxy = (OrderService) new ProxyFactroy(orderService).getProxy();
        orderServiceProxy.service();
    }
}
