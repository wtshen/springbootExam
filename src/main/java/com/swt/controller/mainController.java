package com.swt.controller;

import com.swt.model.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wtshen on 18/2/17.
 */
@RestController
public class mainController {

    @Value("${username}")
    private String userName;

    @Value("${userage}")
    private Integer userAge;


    @Autowired
    private userInfo userInfo;

    @GetMapping(value = "/hello")
    public String hello() {
        return String.format("%s:%d", userName, userAge);
    }

    @GetMapping(value = "/hello3")
    public String hello1() {
        return String.format("%s:%d", userInfo.getUserName(), userInfo.getUserAge());
    }
}
