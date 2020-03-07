package spring.aop.proxy.myaop;

import org.springframework.stereotype.Component;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:52 PM 2020/3/7.
 * @Modified By:
 */
@Component
public class ChinesePerson implements IPerson {
    @Override
    public String run() {
        System.out.println("run()");
        return "chinese run";
    }
}
