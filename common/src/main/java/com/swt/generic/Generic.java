package com.swt.generic;

/**
 * @Author: wtshen
 * @Description: 实例化泛型类时，必须指定T的具体类型
 * @Date: Created in 15:19 2018/9/20
 * @Modified By:
 */
public class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public <T> T genericMethod(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T instance = tClass.newInstance();
        return instance;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 泛型的类型参数只能是类类型（含自定义类）
        Generic<Integer> integerGeneric = new Generic<>(123456);
        System.out.println(integerGeneric.getKey());

        Generic<String> stringGeneric = new Generic<>("key_value");
        System.out.println(stringGeneric.getKey());

        Object o = integerGeneric.genericMethod(Class.forName("com.swt.javaBasic.deepCopy.Seat"));
        System.out.println(o);
    }
}
