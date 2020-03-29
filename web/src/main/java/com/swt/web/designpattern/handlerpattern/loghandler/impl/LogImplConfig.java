package com.swt.web.designpattern.handlerpattern.loghandler.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 8:21 PM 2020/3/29.
 * @Modified By:
 */
@Configuration
public class LogImplConfig {
    @Bean
    ConsoleLogger consoleLogger() {
        return new ConsoleLogger(1);
    }

    @Bean
    FileLogger fileLogger() {
        return new FileLogger(2);
    }

    @Bean
    ErrorLogger errorLogger() {
        return new ErrorLogger(3);
    }
}
