package com.swt.reflection;

import java.lang.reflect.*;
import java.util.Scanner;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:12 AM 2020/2/9.
 * @Modified By:
 */
public class ReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name(e.g. java.util.Date):");
            name = in.next();
        }

        try {
            Class c1 = Class.forName(name);
            Class superc1 = c1.getSuperclass();
            // 描述 public 和 static 等修饰符
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if (superc1 != null && superc1 != Object.class) {
                System.out.print(" extends " + superc1.getName());
            }
            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private static void printConstructors(Class c1) {
        System.out.println("Constructors:");
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");

            Class[] exceptionTypes = constructor.getExceptionTypes();
            for (Class exceptionType : exceptionTypes) {
                System.out.println(exceptionType.getName());
            }
        }
    }

    private static void printMethods(Class c1) {
        System.out.println("Methods:");
        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Class retType = declaredMethod.getReturnType();
            String name = declaredMethod.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(declaredMethod.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType + " " + name + "(");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");

            Class[] exceptionTypes = declaredMethod.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType.getName());
            }
        }
    }

    private static void printFields(Class c1) {
        System.out.println("Fields:");
        // 返回全部域
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Class<?> type = declaredField.getType();
            String name = declaredField.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(declaredField.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type + " " + name + ";");
        }
    }
}
