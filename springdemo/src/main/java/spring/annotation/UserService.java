package spring.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 7:49 AM 2020/2/22.
 * @Modified By:
 */
@Component // 在IOC容器中加入对象名称与类名相同，首字母小写
public class UserService {
    /**
     *  属性注入，写在字段上
     */
    @Resource
    private UserDao userDao;

    public void save() {
        userDao.save();
    }
}
