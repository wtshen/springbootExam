package com.swt.generic.genericclass;

/**
 * @Author: wtshen
 * @Description: 此处T可以随意写为任意标识，常见的T、E、K、V
 * 在实例化泛型类时，必须指定T的具体类型
 * @Date: Created in 12:32 PM 2020/2/1.
 * @Modified By:
 */
public class Generic<T> {
    /**
     * key这个成员变量的类型为T，T的类型由外部制订
     */
    private T key;

    /**
     * 泛型构造方法的形参key的类型也为T，T的类型由外部指定
     *
     * @param key
     */
    public Generic(T key) {
        this.key = key;
    }

    public Generic() {

    }

    /**
     * 泛型方法getKey的返回值类型为T，T的类型由外部指定
     *
     * @return
     */
    public T getKey() {
        return this.key;
    }

    /**
     * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
     * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
     public E setKey(E key){
     this.key = keu
     }
     */
}
