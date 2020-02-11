package com.swt.aop.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:46 PM 2020/2/10.
 * @Modified By:
 */
public class TargetInterceptor implements MethodInterceptor {


    /**
     * @param o           由CGLib动态生成的代理类实例
     * @param method      上文中实体类所调用的被代理的方法引用
     * @param objects     参数值列表
     * @param methodProxy 生成的代理类对方法的代理引用
     * @return 从代理实例的方法调用返回的值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        // 调用代理类实例上的proxy方法的父类方法（即实体类TargetObject中对应的方法）
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(" 调用后" + result);
        return result;
    }
}
