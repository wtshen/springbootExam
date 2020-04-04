package com.swt.web.designpattern.proxypattern.dynamicproxy.cglibproxy;

import com.swt.web.designpattern.proxypattern.dynamicproxy.cglibproxy.impl.OrderServiceImpl;
import com.swt.web.designpattern.proxypattern.dynamicproxy.cglibproxy.impl.PayServiceImpl;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:24 PM 2020/4/3.
 * @Modified By:
 */
public class CGLibTest {
    public static void main(String[] args){
        OrderServiceImpl orderService = (OrderServiceImpl) new CGLibProxyFactory(new OrderServiceImpl()).getProxy();
        orderService.service();

        PayServiceImpl payService = (PayServiceImpl) new CGLibProxyFactory(new PayServiceImpl()).getProxy();
        payService.pay();
    }
}
