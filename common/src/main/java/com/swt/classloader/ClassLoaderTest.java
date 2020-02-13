package com.swt.classloader;

import org.apache.commons.lang.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 3:15 PM 2020/2/13.
 * @Modified By:
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            LocalClassLoader lcl = new LocalClassLoader();
            Class<?> aClass = lcl.loadClass("com.swt.classloader.Key");
            Field field = FieldUtils.getField(aClass,"key",true);
            Object o = field.get(aClass.newInstance());
            System.out.println(o);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            URLClassLoader ucl = new URLClassLoader(new URL[]{new URL("file", null, "/Users/wtshen/MyProject/springbootExam/common/src/main/java/com/swt/classloader/")});
            Class<?> cls = ucl.loadClass("com.swt.classloader.Key");
            Field field = FieldUtils.getField(cls, "key", true);
            Object value = field.get(cls.newInstance());
            System.out.println(value);
        } catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
