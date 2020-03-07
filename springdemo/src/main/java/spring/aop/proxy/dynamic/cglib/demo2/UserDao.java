package spring.aop.proxy.dynamic.cglib.demo2;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:53 AM 2020/3/7.
 * @Modified By:
 */
public class UserDao {
    public String save(){
        System.out.println("--save object--");
        return "success";
    }
}
