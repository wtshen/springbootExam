package com.swt.web.controller;

import com.webdev.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wtshen on 18/2/17.
 */
@RestController
public class MainController {

    @Value("${username}")
    private String userName;

    @Value("${userage}")
    private Integer userAge;


    @Autowired
    private UserInfo UserInfo;

    @GetMapping(value = "/hello")
    public String hello() {
        return String.format("%s:%d", userName, userAge);
    }

    @GetMapping(value = "/hello3")
    public String hello1() {
        return String.format("%s:%d", UserInfo.getUserName(), UserInfo.getUserAge());
    }
}
