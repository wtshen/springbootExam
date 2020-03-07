package spring.aop.proxy.myaop;

import java.lang.reflect.Proxy;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:56 PM 2020/3/7.
 * @Modified By:
 */
public class ProxyFactory {
    private static Object target;
    private static CustomAop customAop;

    public static Object getProxy(Object _target,CustomAop _customAop) {
        target = _target;
        customAop = _customAop;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    customAop.before();
                    Object result = method.invoke(target, args);
                    customAop.after();
                    return result;
                });
    }
}
