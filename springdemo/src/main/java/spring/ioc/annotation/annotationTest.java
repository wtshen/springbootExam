package spring.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 7:53 AM 2020/2/22.
 * @Modified By:
 */
public class annotationTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        UserAction userAction = (UserAction) context.getBean("userAction");
        userAction.addUser();
    }
}
