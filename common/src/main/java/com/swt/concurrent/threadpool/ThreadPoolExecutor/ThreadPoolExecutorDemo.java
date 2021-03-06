package com.swt.concurrent.threadpool.ThreadPoolExecutor;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.Executor;

/**
 * @Author: wtshen
 * @Description: 启动类中调用，无法使用@Autowire,可能是还没加载完成就开始运行了
 * @Date: Created in 10:13 2018/7/12
 * @Modified By:
 */
@SpringBootApplication
public class ThreadPoolExecutorDemo implements ApplicationContextAware {
    private static ApplicationContext threadPoolApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        threadPoolApplicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(ThreadPoolExecutorDemo.class, args);

        Executor asyncServiceExecutor = (Executor) threadPoolApplicationContext.getBean("taskServiceExecutor");
        asyncServiceExecutor.execute(() -> System.out.println("1111"));
    }
}
