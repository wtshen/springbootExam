package com.swt.web;

import com.swt.collection.UserInfo;
import com.swt.nosql.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 1:09 PM 2020/6/21.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStartApplication.class)
public class RedisTest {
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void setValue() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(3);
        userInfo.setSalary(100000.0D);
        userInfo.setName("swt");
        userInfo.setAge(40);
        redisUtil.set("1", userInfo);

        System.out.println(redisUtil.get(userInfo.getId().toString()));
    }
}
