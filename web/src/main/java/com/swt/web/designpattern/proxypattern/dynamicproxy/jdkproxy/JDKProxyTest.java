package com.swt.web.designpattern.proxypattern.dynamicproxy.jdkproxy;

import com.swt.web.designpattern.proxypattern.dynamicproxy.jdkproxy.impl.OrderImpl;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:00 PM 2020/4/3.
 * @Modified By:
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        OrderService orderService = new OrderImpl();
        // 在项目根目录 com\sun\proxy 下生成系统产生的 class 文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        OrderService orderServiceProxy = (OrderService) new ProxyFactroy(orderService).getProxy();
        orderServiceProxy.service();
    }
}
