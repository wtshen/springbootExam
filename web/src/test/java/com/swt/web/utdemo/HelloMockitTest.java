package com.swt.web.utdemo;

import com.swt.web.SpringBootStartApplication;
import com.swt.web.utdemo.simple.HelloMockit;
import com.swt.web.utdemo.simple.HelloMockitExt;
import com.swt.web.utdemo.simple.HelloService;
import mockit.*;
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

    //<editor-fold desc="#测试类中方法">

    /**
     * 由于由静态方法所以构建一个静态类继承Mockup
     */
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

    /**
     * Mocked+Expectations 测试静态方法
     *
     * @param locale
     */
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


    /**
     * Mockup+Mock
     */
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
    //</editor-fold>

    static class HelloMockitMockup extends MockUp<HelloMockit> {
        @Mock
        private Integer privateMethod() {
            return 10;
        }
        @Mock
        public static int staticMethod() {
            return 20;
        }
    }

    /**
     * @param helloService
     * @Capturing mock接口实现，除了具有@Mocked的特点，还能影响它的子类/实现类
     */
    @Test
    public void callSayHelloTest(@Capturing HelloService helloService, @Mocked HelloMockitExt helloMockitExtLocal) {
        new Expectations() {
            {
                helloMockitExtLocal.sayHello();
                result = "";
                helloService.m1();
                result = 10;
                HelloMockit.staticMethod();
                result = 20;
            }
        };

        new HelloMockitMockup();
        // 测试私有方法
        Assert.assertEquals(10, helloMockit.callPrivateMethod());
        // 测试静态方法
        Assert.assertEquals(20,HelloMockit.staticMethod());
        // 测试异常
        expectedEx.expect(IllegalArgumentException.class);
        // 测试接口实现
        Integer result = helloMockit.callHelloService(10);
        Assert.assertEquals(10, result.intValue());
    }
}
