package spring.ioc.facotry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:12 AM 2020/2/20.
 * @Modified By:
 */
public class PersonTest {
    public static void main(String[] args){
        System.out.println("--静态工厂方法");
        // 静态工厂方法
        ApplicationContext context = new ClassPathXmlApplicationContext("factory.xml");
        Chinese chinese = (Chinese) context.getBean("chinese");
        chinese.say();
        American american = (American) context.getBean("american");
        american.say();

        System.out.println("--实例工厂方法");
        // 实例工厂方法
        Chinese chinese1 = (Chinese) context.getBean("ch");
        chinese1.say();
        American american1 = (American) context.getBean("us");
        american1.say();
    }
}
