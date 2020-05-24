package com.swt.web.utdemo.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 2:45 PM 2020/5/23.
 * @Modified By:
 */
@Service
public class HelloMockit {
    @Autowired
    HelloMockitExt helloMockitExt;

    public void callSayHello() {
        String result = helloMockitExt.sayHello();
        doSomething(result);
    }

    public Integer callHelloService(Integer arg) {
        String result = helloMockitExt.sayHello();
        doSomething(result);

        HelloService helloService = new HelloImpl();
        int m1Result = helloService.m1();
        System.out.println(m1Result);
        if (arg.equals(m1Result)) {
            return m1Result;
        }
        int m2Result = helloService.m2();
        System.out.println(m2Result);
        if (arg.equals(m2Result)) {
            return m2Result;
        }
        return 0;
    }

    private void doSomething(String arg) {
        if (StringUtils.isEmpty(arg)) {
            throw new IllegalArgumentException("arg not found");
        }
    }

    public int callPrivateMethod() {
        return privateMethod();
    }

    private Integer privateMethod() {
        return 1;
    }

    public static int staticMethod() {
        return 2;
    }
}
