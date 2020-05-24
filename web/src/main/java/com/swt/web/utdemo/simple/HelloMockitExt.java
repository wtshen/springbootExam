package com.swt.web.utdemo.simple;

import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 2:45 PM 2020/5/23.
 * @Modified By:
 */
@Service
public class HelloMockitExt {
    // 向JMockit打招呼
    public String sayHello() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            throw new NullPointerException();
        }
        if (locale.equals(Locale.CHINA)) {
            // 在中国，就说中文
            return "你好，JMockit!";
        } else {
            // 在其它国家，就说英文
            return "Hello，JMockit!";
        }
    }
}
