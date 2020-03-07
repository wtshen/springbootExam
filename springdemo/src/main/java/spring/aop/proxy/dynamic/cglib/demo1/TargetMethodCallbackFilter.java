package spring.aop.proxy.dynamic.cglib.demo1;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:01 AM 2020/2/11.
 * @Modified By:
 */
public class TargetMethodCallbackFilter implements CallbackFilter {
    /**
     * 过滤方法
     * 返回的值为数字，代表了Callback数组中的索引位置，要到用的Callback
     */
    @Override
    public int accept(Method method) {
        if ("method1".equals(method.getName())){
            System.out.println("filter method1==0");
            return 0;
        }
        if ("method2".equals(method.getName())){
            System.out.println("filter method2==1");
            return 1;
        }
        if ("method3".equals(method.getName())){
            System.out.println("filter method3==2");
            return 2;
        }
        return 0;
    }
}
