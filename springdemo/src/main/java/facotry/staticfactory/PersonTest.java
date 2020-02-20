package facotry.staticfactory;

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
        // 静态工厂方法
        ApplicationContext context = new ClassPathXmlApplicationContext("factory.xml");
        Chinese chinese = (Chinese) context.getBean("chinese");
        chinese.say();
        American american = (American) context.getBean("american");
        american.say();

        // 实例工厂方法
        Chinese chinese1 = (Chinese) context.getBean("chinese");
        chinese1.say();
        American american1 = (American) context.getBean("american");
        american1.say();
    }
}
