package com.swt.web.designpattern.proxypattern.dynamicproxy.myjdkproxy.v2;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 8:56 PM 2020/4/4.
 * @Modified By:
 */
public class JavaClassLoader extends ClassLoader {
    private String path = "/Users/wtshen/MyProject/springbootExam/web/src/main/java/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> cls = super.findLoadedClass(name);
        if (cls != null) {
            return cls;
        }
        if (!name.endsWith(".$Proxy0")) {
            return super.loadClass(name);
        }

        try {
            InputStream is = new FileInputStream(path + name.replace(".", "/") + ".class");
            byte[] bytes = IOUtils.toByteArray(is);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);

    }
}
