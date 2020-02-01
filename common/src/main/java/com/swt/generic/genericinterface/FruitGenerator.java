package com.swt.generic.genericinterface;

/**
 * @Author: wtshen
 * @Description: 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需要将泛型的声明也一起加到类中
 * @Date: Created in 1:03 PM 2020/2/1.
 * @Modified By:
 */
public class FruitGenerator<T> implements Generator<T> {
    @Override
    public T next() {
        return null;
    }
}
