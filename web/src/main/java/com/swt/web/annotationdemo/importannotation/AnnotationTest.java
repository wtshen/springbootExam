package com.swt.web.annotationdemo.importannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 4:34 PM 2020/3/15.
 * @Modified By:
 */
public class AnnotationTest {
    public static void main(String[] args){
        // 方式1
        /*ApplicationContext ctx = new AnnotationConfigApplicationContext(ImportStudent.class,ImportTeacher.class);

        //Student student = (Student)ctx.getBean("com.swt.web.annotationdemo.importannotation.Student");
        Student student = ctx.getBean(Student.class);
        student.say();

        GoodStudent goodStudent = (GoodStudent)ctx.getBean("com.swt.web.annotationdemo.importannotation.GoodStudent");
        goodStudent.say();

        Teacher teacher = (Teacher)ctx.getBean("com.swt.web.annotationdemo.importannotation.Teacher");
        teacher.say();

        System.out.println("开始打印...");
        for (String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }*/

        // 方式2 和方式1一样的，只不过方式1的构造函数中自动调用了register和refresh方法
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(TeacherConfig.class);
        ctx.refresh();


        GoodStudent goodStudent = ctx.getBean(GoodStudent.class);
        goodStudent.say();

        /*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(GoodStudent.class);
        ctx.refresh();
        for (String s : ctx.getBeanDefinitionNames()) {
            System.out.println(s);
        }

        ctx.getBean(GoodStudent.class).say();*/
    }
}
