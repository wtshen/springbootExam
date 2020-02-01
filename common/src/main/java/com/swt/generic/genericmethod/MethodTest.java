package com.swt.generic.genericmethod;

/**
 * @Author: wtshen
 * @Description: 只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法
 * <T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T
 * @Date: Created in 5:12 PM 2020/2/1.
 * @Modified By:
 */
public class MethodTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object obj = genericMethod(Class.forName("com.swt.generic.genericclass.Generic"));
        System.out.println(obj);
    }

    private static <T> T genericMethod(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T instance = tClass.newInstance();
        return instance;
    }
}
