package com.swt.javaBasic.introspector;

import com.swt.javaBasic.deepCopy.Seat;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 15:57 2020/1/22
 * @Modified By:
 */
public class IntrospectorDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Seat.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if ("class".equalsIgnoreCase(propertyDescriptor.getName())) {
                //continue;
            }
            System.out.println("property type:" + propertyDescriptor.getPropertyType());
            System.out.println("property name:" + propertyDescriptor.getName());
            System.out.println("property ReadMethod:" + propertyDescriptor.getReadMethod());
            System.out.println("property WriteMethod:" + propertyDescriptor.getWriteMethod());


        }
    }
}
