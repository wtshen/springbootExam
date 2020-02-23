package spring.ioc.construct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.construct.nopara.Person;
import spring.ioc.construct.para.Staff;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:38 PM 2020/2/19.
 * @Modified By:
 */
public class PersonTest {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("construct.xml");
        Person person = (Person)applicationContext.getBean("person");
        person.input();

        Person person1 = (Person)applicationContext.getBean("person");
        System.out.println(person.equals(person1));


        Staff person2 = (Staff) applicationContext.getBean("staff");
    }
}
