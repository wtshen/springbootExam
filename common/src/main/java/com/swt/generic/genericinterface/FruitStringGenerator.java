package com.swt.generic.genericinterface;

import java.util.Random;

/**
 * @Author: wtshen
 * @Description: 在实现类实现泛型接口时，如已将泛型类型传入参数类型，则所有使用泛型的地方都要替换成传入的实参类型
 * @Date: Created in 1:10 PM 2020/2/1.
 * @Modified By:
 */
public class FruitStringGenerator implements Generator<String> {
    private  String[] fruits = new String[]{"Apple", "Banana", "Pear"};
    @Override
    public String next() {
        Random random = new Random();
        return fruits[random.nextInt(3)];
    }
}
