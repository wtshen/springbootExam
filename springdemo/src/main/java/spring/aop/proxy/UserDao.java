package spring.aop.proxy;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:56 AM 2020/2/23.
 * @Modified By:
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("---------保存数据");
    }
}
