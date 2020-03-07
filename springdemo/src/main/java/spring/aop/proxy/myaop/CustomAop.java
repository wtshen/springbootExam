package spring.aop.proxy.myaop;

import org.springframework.stereotype.Component;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:54 PM 2020/3/7.
 * @Modified By:
 */
@Component
public class CustomAop {
    public void before(){
        System.out.println("--warm up--");
    }

    public void after(){
        System.out.println("--have a rest--");
    }
}
