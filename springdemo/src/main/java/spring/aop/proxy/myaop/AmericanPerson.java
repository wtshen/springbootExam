package spring.aop.proxy.myaop;

import org.springframework.stereotype.Component;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:42 PM 2020/3/7.
 * @Modified By:
 */
@Component
public class AmericanPerson {
    public void run() {
        System.out.println("call run()");
    }
}
