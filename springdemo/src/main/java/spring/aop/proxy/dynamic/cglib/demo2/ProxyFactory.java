package spring.aop.proxy.dynamic.cglib.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:cglib子类代理工厂(对UserDao在内存中动态创建一个代理)
 * @Date: Created in 9:55 AM 2020/3/7.
 * @Modified By:
 */
public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        // 1.工具类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(target.getClass());
        // 3.设置回调方法
        enhancer.setCallback(this);
        // 4.创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("--transaction begin--");
        Object result = method.invoke(target, objects);
        System.out.println("--transaction end--");
        return result;
    }
}
