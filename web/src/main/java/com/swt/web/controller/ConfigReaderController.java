package com.swt.web.controller;

import com.swt.web.viewmodel.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 读取配置文件中属性
 * Created by wtshen on 18/2/17.
 */
@RestController
public class ConfigReaderController {

    @Value("${username}")
    private String userName;

    @Value("${userage}")
    private Integer userAge;

    @Autowired
    private UserInfo userInfo;

    @RequestMapping(value = "/index")
    public String hello() {
        return String.format("%s:%d", userName, userAge);
    }

    @GetMapping(value = "/hello")
    public String hello1() {
        return String.format("%s:%d", userInfo.getUserName(), userInfo.getUserAge());
    }
}
