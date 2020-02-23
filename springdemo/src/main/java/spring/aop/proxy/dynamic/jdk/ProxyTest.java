package spring.aop.proxy.dynamic.jdk;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:33 AM 2020/2/23.
 * @Modified By:
 */
public class ProxyTest {
    public static void main(String[] args){
        IUserDao userDao = new UserDao();
        IUserDao proxyInstance = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        proxyInstance.save();

    }
}
