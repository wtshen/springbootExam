package spring.aop.proxy;

/**
 * @Author: wtshen
 * @Description: 静态代理，要求代理对象与目标对象要实现一样的接口
 * @Date: Created in 10:57 AM 2020/2/23.
 * @Modified By:
 */
public class UserDaoProxy implements IUserDao {
    IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("事务开始");
        this.target.save();
        System.out.println("事务结束");
    }
}
