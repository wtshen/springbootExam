package com.swt.generic.genericclass;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 12:15 PM 2020/2/1.
 * @Modified By:
 */
public class GenericTest {
    public static void main(String[] args) {
        try {
            test1();
        } catch (Exception e){
            e.printStackTrace();
        }

        test2();
    }

    /**
     * java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
     */
    private static void test1() {
        List arrayList = Lists.newArrayList();
        arrayList.add("aaa");
        arrayList.add(100);

        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String) arrayList.get(i);
            System.out.println("范型测试,item=" + item);
        }
    }

    private static void test2(){
        List<String> stringArrayList = Lists.newArrayList();
        List<Integer> integerList = Lists.newArrayList();
        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerList = integerList.getClass();

        if (classIntegerList.equals(classStringArrayList)){
            System.out.println("类型相同");
        }
    }
}
