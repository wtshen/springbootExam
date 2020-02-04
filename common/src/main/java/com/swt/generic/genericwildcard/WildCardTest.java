package com.swt.generic.genericwildcard;

import com.sun.org.apache.xpath.internal.operations.Number;
import com.swt.generic.genericclass.Generic;
import com.swt.generic.genericinterface.Generator;

/**
 * @Author: wtshen
 * @Description: “?”声明的集合，不能往此集合中添加元素，所以它只能作为生产者(亦即它只能被迭代)
 * @Date: Created in 1:17 PM 2020/2/1.
 * @Modified By:
 */
public class WildCardTest {
    public static void main(String[] args) {
        Generic<Number> numberGeneric = new Generic(111111);
        showKeyValue(numberGeneric);

        Generic<Integer> integerGeneric = new Generic(22222);
        //不兼容的类型: com.swt.generic.genericclass.Generic<java.lang.Integer>无法转换为com.swt.generic.genericclass.Generic<com.sun.org.apache.xpath.internal.operations.Number>
        // 同一种泛型可以对应多个版本，不同版本类实例是不兼容的
        //showKeyValue(integerGeneric);

        // success
        showWildCardKeyValue(integerGeneric);
    }

    private static void showKeyValue(Generic<Number> obj) {
        System.out.println("key value is " + obj.getKey());
    }

    /**
     * 此处的？是类型实参，不是类型行参，是一种真实的类型，用于解决当具体类型不确定的时候
     * @param obj
     */
    private static void showWildCardKeyValue(Generic<?> obj) {
        System.out.println("key value is " + obj.getKey());
    }
}
