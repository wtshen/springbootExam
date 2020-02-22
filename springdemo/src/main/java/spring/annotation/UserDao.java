package spring.annotation;

import org.springframework.stereotype.Component;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 7:48 AM 2020/2/22.
 * @Modified By:
 */
@Component
public class UserDao {
    public void save(){
        System.out.println("保存到数据库");
    }
}
