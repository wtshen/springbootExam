package spring.ioc.facotry;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:02 AM 2020/2/20.
 * @Modified By:
 */
public class PersonFactory {
    /**
     * 静态工厂方法
     * @param arg
     * @return
     */
    public static Person getInstance(String arg) {
        if ("chinese".equalsIgnoreCase(arg)) {
            return new Chinese();
        } else {
            return new American();
        }
    }

    /**
     * 实例工厂方法
     * @param arg
     * @return
     */
    public Person getPerson(String arg) {
        if ("chinese".equalsIgnoreCase(arg)) {
            return new Chinese();
        } else {
            return new American();
        }
    }
}
