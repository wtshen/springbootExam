package spring.aop.proxy.dynamic.cglib.demo2;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:03 AM 2020/3/7.
 * @Modified By:
 */
public class test {
    public static void main(String[] args){
        // 目标对象
        UserDao target = new UserDao();
        // 代理对象
        UserDao userDao = (UserDao) new ProxyFactory(target).getProxyInstance();
        userDao.save();
        System.out.println(userDao.getClass());
    }
}
