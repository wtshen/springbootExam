package com.swt.generic.genericclass;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 12:39 PM 2020/2/1.
 * @Modified By:
 */
public class GenericTest1 {
    public static void main(String[] args) {
        // 泛型的类型参数只能是类类型（包括自定义类），当不能时简单类型
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        // 传入的实参类型需要与泛型的类型参数的类型相同
        Generic<String> genericString = new Generic<>("key_value");

        System.out.println("key is:" + genericInteger.getKey());
        System.out.println("key is " + genericString.getKey());

        // 如果不传入泛型类型实参，泛型类中的泛型方法和成员变量定义的类型可以为任意类型
        Generic generic = new Generic("11111");
        Generic generic1 = new Generic(22222);
        Generic generic2 = new Generic(33.33);
        System.out.println("key is:" + generic.getKey());
        System.out.println("key is:" + generic1.getKey());
        System.out.println("key is:" + generic2.getKey());
    }
}
