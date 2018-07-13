package com.swt.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 19:22 2018/7/12
 * @Modified By:
 */
@Slf4j
@RestController
public class LogController {
    @RequestMapping("/log")
    public void log() {
        String name = "felix";
        int age = 39;
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        log.trace("日志输出 trace");
        log.debug("日志输出 debug");
        log.info("日志输出 info");
        log.warn("日志输出 warn");
        log.error("日志输出 error");

        log.info("name:" + name + ",age:" + age);
        log.info("name:{},age{}", name, age);
    }
}
