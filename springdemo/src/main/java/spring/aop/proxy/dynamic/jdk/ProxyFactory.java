package spring.aop.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:28 AM 2020/2/23.
 * @Modified By:
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Object o = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("事务开始");
                    method.invoke(target, args);
                    System.out.println("事务完成");
                    return null;
                });
        return o;
    }
}
