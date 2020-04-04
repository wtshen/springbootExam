package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v1;

import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v1.impl.JDKInvocationHandlerImpl;
import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v1.impl.OrderServiceImpl;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 4:19 PM 2020/4/4.
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        OrderService proxy0 = new $Proxy0(new JDKInvocationHandlerImpl(new OrderServiceImpl()));
        proxy0.service();
    }
}
