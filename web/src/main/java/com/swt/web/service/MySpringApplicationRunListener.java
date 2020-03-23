package com.swt.web.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:28 PM 2020/3/23.
 * @Modified By:
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {
    SpringApplication application;
    String[] args;

    /**
     * private <T> Collection<T> getSpringFactoriesInstances(Class<T> type,
     Class<?>[] parameterTypes, Object... args) {
     ClassLoader classLoader = getClassLoader();
     // Use names and ensure unique to protect against duplicates
     Set<String> names = new LinkedHashSet<>(
     SpringFactoriesLoader.loadFactoryNames(type, classLoader));
     // 通过反射方式获取类，其中需要一个构造函数，所以不加构造函数会报错
     ---->>List<T> instances = createSpringFactoriesInstances(type, parameterTypes,classLoader, args, names);<<----
     AnnotationAwareOrderComparator.sort(instances);
     return instances;
     }
     * @param application
     * @param args
     */
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println("MySpringApplicationRunListener starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        // 配置文件读取到程序中 需要自己将本地文件读取到容器中，然后再放入到Springboot容器中
        Properties properties = new Properties();
        try {
            // 读取my.properties文件
            properties.load(this.getClass().getClassLoader().getResourceAsStream("my.properties"));
            // 读取名称为my
            PropertySource propertySource = new PropertiesPropertySource("my", properties);
            // 将资源添加到项目中
            MutablePropertySources propertySources = environment.getPropertySources();
            // 通过该api接口可以将配置文件读取到SpringBoot项目中(***核心方法***)
            propertySources.addLast(propertySource);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
