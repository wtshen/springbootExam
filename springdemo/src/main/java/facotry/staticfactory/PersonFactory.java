package facotry.staticfactory;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:02 AM 2020/2/20.
 * @Modified By:
 */
public class PersonFactory {
    public static Person getInstance(String arg) {
        if ("chinese".equalsIgnoreCase(arg)) {
            return new Chinese();
        } else {
            return new American();
        }
    }

    public Person getPerson(String arg) {
        if ("chinese".equalsIgnoreCase(arg)) {
            return new Chinese();
        } else {
            return new American();
        }
    }
}
