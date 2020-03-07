package spring.aop.proxy.myaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:43 PM 2020/3/7.
 * @Modified By:
 */
public class CglibProxy implements MethodInterceptor {
    @Autowired
    CustomAop customAop;

    public Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        customAop.before();
        methodProxy.invokeSuper(o, objects);
        customAop.after();
        return null;
    }
}
