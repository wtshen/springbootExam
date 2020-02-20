package spring.construct.para;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:19 AM 2020/2/20.
 * @Modified By:
 */
public class Staff {
    private String name;
    private Integer age;

    public Staff(String name, Integer age) {
        System.out.println("Spring容器开始通过有参构造器创建Bean实例------------" + name + ":" + age);
    }
}
