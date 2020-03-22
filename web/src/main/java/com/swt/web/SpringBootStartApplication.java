package com.swt.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wtshen
 * @Description:
 * ServletInitializer是Servlet初始化器，意思是当本应用作为tomcat的一个webapp时，就调用configure函数，这是tomcat容器调用的，这时整个应用就相当于Servlet。
    当作为SpringApplication运行时，会执行main函数，但是不会执行上面的configure函数
 * @Date: Created in 10:33 2018/5/30
 * @Modified By:
 */

@SpringBootApplication(scanBasePackages = "com.swt.*")
public class SpringBootStartApplication  {

    /*extends SpringBootServletInitializer
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // 设置启动类,用于独立tomcat运行的入口
        return application.sources(SpringBootStartApplication.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApplication.class, args);
    }
}
