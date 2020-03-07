package spring.aop.proxy.myaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 7:06 PM 2020/3/7.
 * @Modified By:
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myaop.xml");
        IPerson person = (IPerson) context.getBean("proxyFactory");
        System.out.println("result:" + person.run());
    }
}
