package com.swt.aop.cglib;

/**
 * @Author: wtshen
 * @Description: 没有借口实现, 需要CGLib 动态代理的目标类
 * @Date: Created in 9:42 PM 2020/2/10.
 * @Modified By:
 */
public class TargetObject {
    public String method1(String paraName) {
        return paraName;
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []" + getClass();
    }
}
