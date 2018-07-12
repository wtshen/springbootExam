package com.swt.web.controller;

import com.google.common.collect.Lists;
import com.swt.collection.UserInfo;
import com.swt.web.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 13:25 2018/7/12
 * @Modified By:
 */
@RestController
public class ThreadPoolController {

    @Autowired
    QueryService queryService;

    @RequestMapping(value = "/threadPool")
    public String threadPool() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        LocalDateTime now = LocalDateTime.now();
        List<UserInfo> userInfoList = queryService.threadHandle(list);
        System.out.println("全部执行耗时：" + Duration.between(now, LocalDateTime.now()).toMillis());
        userInfoList.forEach(i -> System.out.println(i));
        return userInfoList.toString();
    }
}
