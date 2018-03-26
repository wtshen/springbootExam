package com.javabase.concurrent.synchronizer.test023;

import javax.smartcardio.CommandAPDU;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午8:43 18/3/26.
 * @Modified By:
 */
public class OutClass {
    public void display() {
        System.out.println("this is OutClass");
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

        public OutClass getOutClass() {
            return OutClass.this;
        }
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.display();

        // 创建一个内部类对象，必须利用outerClass.new
        OutClass.InnerClass innerClass = outClass.new InnerClass();
        innerClass.display();

        outClass.displayInnerClass();
    }
}
