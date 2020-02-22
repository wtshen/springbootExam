package spring.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 7:49 AM 2020/2/22.
 * @Modified By:
 */
@Component
public class UserService {
    @Resource
    private UserDao userDao;

    public void save() {
        userDao.save();
    }
}
