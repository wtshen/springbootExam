package com.swt.web.designpattern.proxypattern.staticproxy;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:58 AM 2020/2/23.
 * @Modified By:
 */
public class ProxyTest {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);

        userDaoProxy.save();
    }
}
