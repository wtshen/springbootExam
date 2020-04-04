package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v1;

import com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v1.impl.JDKInvocationHandlerImpl;

import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 4:13 PM 2020/4/4.
 * @Modified By:
 */
public class $Proxy0 implements OrderService {
    JDKInvocationHandlerImpl h;

    public $Proxy0(JDKInvocationHandlerImpl h) {
        this.h = h;
    }

    @Override
    public void service() throws Throwable {
        Method method = OrderService.class.getMethod("service", new Class[]{});
        this.h.invoke(this, method, null);
    }
}
