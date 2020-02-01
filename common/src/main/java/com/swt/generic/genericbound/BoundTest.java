package com.swt.generic.genericbound;

import com.swt.generic.genericclass.Generic;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:39 PM 2020/2/1.
 * @Modified By:
 */
public class BoundTest {
    /**
     * 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
     * @param obj
     */
    /*public void showKeyValue(Generic<? extends Number> obj){
        System.out.println(obj.getKey());
    }*/

    public <T extends Number> T showKeyValue(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void main(String[] args){
        Generic<String> generic1 = new Generic("11111");
        Generic<Integer> generic2 = new Generic(22222);
        Generic<Float> generic3 = new Generic(2.4f);
        Generic<Double> generic4 = new Generic(2.56);

        BoundTest boundTest = new BoundTest();
        // 这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        //boundTest.showKeyValue(generic1);

        boundTest.showKeyValue(generic2);
        boundTest.showKeyValue(generic3);
        boundTest.showKeyValue(generic4);
    }
}
