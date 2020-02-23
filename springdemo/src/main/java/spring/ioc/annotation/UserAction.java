package spring.ioc.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 7:49 AM 2020/2/22.
 * @Modified By:
 */
@Component
public class UserAction {
    @Resource
    private UserService userService;

    public String addUser() {
        userService.save();
        return null;
    }
}
