package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v1;

import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 3:56 PM 2020/4/4.
 * @Modified By:
 */
public interface JDKInvocationHandlerService {
    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
