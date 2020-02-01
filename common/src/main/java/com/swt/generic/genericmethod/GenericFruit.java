package com.swt.generic.genericmethod;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 5:43 PM 2020/2/1.
 * @Modified By:
 */
public class GenericFruit {
    class Fruit {
        @Override
        public String toString() {
            return "fruit";
        }
    }

    class Apple extends Fruit {
        @Override
        public String toString() {
            return "apple";
        }
    }

    class Person {
        @Override
        public String toString() {
            return "Person";
        }
    }

    class GenericTest<T> {
        public void show_1(T t) {
            System.out.println("show_1:" + t.toString());
        }

        /**
         * 在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
         * @param t
         * @param <T>
         */
        public <T> void show_2(T t) {
            System.out.println("show_2:" + t.toString());
        }

        public <E> void show_3(E e) {
            System.out.println("show_3:" + e.toString());
        }
    }


    public static void main(String[] args) {
        GenericFruit genericFruit = new GenericFruit();
        genericFruit.Init();
    }

    private void Init() {
        Apple apple = new Apple();
        Person person = new Person();

        GenericTest<Fruit> genericTest = new GenericTest();
        genericTest.show_1(apple);

        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        //genericTest.show_1(person);

        genericTest.show_2(apple);
        genericTest.show_2(person);

        genericTest.show_3(apple);
        genericTest.show_3(person);
    }
}


