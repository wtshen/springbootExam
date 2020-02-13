package com.swt.classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;


/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 2:51 PM 2020/2/13.
 * @Modified By:
 */
public class LocalClassLoader extends ClassLoader {
    private String path = "/Users/wtshen/MyProject/springbootExam/common/src/main/java/com/swt/classloader/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> cls = super.findLoadedClass(name);
        if (cls != null) {
            return cls;
        }
        if (!name.endsWith(".Key")) {
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
