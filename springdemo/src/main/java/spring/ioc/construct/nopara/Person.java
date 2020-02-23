package spring.ioc.construct.nopara;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:33 PM 2020/2/19.
 * @Modified By:
 */
public class Person {
    private String name;

    public Person() {
        System.out.println("Spring容器开始通过无参构造器创建Bean实例------------");
    }

    /**
     * Spring容器通过setter方法为参数注入值
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void input() {
        System.out.println("欢迎来到我的博客：" + name);
    }
}
