package com.javabase.concurrent.synchronizer.test023;
/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午8:43 18/3/26.
 * @Modified By:
 */
public class OuterClass1 {
    public void display() {
        System.out.println("this is OuterClass1");
    }

    /**
     * 外部类访问内部类元素，需要通过内部类引用访问
     */
    public void displayInnerClass() {
        InnerClass innerClass = new InnerClass();
        innerClass.displayInnerClass();
    }

    public class InnerClass {
        public void display() {
            getOutClass().display();
        }

        public void displayInnerClass() {
            System.out.println("this is InnerClass");
        }

        public OuterClass1 getOutClass() {
            return OuterClass1.this;
        }
    }

    public static void main(String[] args) {
        OuterClass1 outerClass1 = new OuterClass1();
        outerClass1.display();

        // 创建一个内部类对象，必须利用outerClass.new
        OuterClass1.InnerClass innerClass = outerClass1.new InnerClass();
        innerClass.display();

        outerClass1.displayInnerClass();
    }
}
