package com.swt.web.utdemo;

import com.swt.web.SpringBootStartApplication;
import com.swt.web.utdemo.simple.HelloMockit;
import com.swt.web.utdemo.simple.HelloMockitExt;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 2:46 PM 2020/5/23.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStartApplication.class)
public class HelloMockitTest {
    @Autowired
    HelloMockit helloMockit;
    @Autowired
    HelloMockitExt helloMockitExt;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    static class LocaleExt extends MockUp<Locale> {
        static int type;

        LocaleExt(int type) {
            LocaleExt.type = type;
        }

        @Mock
        public static Locale getDefault() {
            if (type == 1) {
                return Locale.CHINA;
            } else {
                return Locale.US;
            }
        }
    }

    @Test
    public void sayHelloTest_CN(@Mocked Locale locale) {
        new Expectations() {
            {
                Locale.getDefault();
                result = Locale.CHINA;
            }
        };
        String result = helloMockitExt.sayHello();
        Assert.assertTrue("你好，JMockit!".equalsIgnoreCase(result));
    }


    @Test
    public void sayHelloTest_EN() {
        new LocaleExt(2);
        String result = helloMockitExt.sayHello();
        Assert.assertTrue("Hello，JMockit!".equalsIgnoreCase(result));
    }

    /**
     * mock异常
     */
    @Test
    public void callSayHelloExceptionTest() {
        new MockUp<HelloMockitExt>() {
            @Mock
            public String sayHello() {
                throw new RuntimeException("not found object");
            }
        };
        expectedEx.expect(RuntimeException.class);
        // mock中message中包含expectMessage则符合
        expectedEx.expectMessage("not found object");
        helloMockit.callSayHello();
    }
}
