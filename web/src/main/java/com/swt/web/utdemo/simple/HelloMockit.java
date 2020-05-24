package com.swt.web.utdemo.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private void doSomething(String arg) {
        System.out.println(arg);
    }
}
