package com.swt.javaBasic.packagescan;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ObjectUtils;

import java.util.Set;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 16:34 2020/1/17
 * @Modified By:
 */
public class PackageScanUtil {
    public static void main(String[] args) {
        // true：默认TypeFilter生效，这种模式会查询出许多不符合你要求的class名
        // false：关闭默认TypeFilter
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);

        // 自定义过滤器(这是扫描全部,但不能扫描出接口)
        // 加了这个，后面那些Filter不加也可以
        // (metadataReader, metadataReaderFactory) -> true  相当于调用了一个匿名方法
        // private static boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {
        //        return true;
        //    }
        TypeFilter includeFilter = (metadataReader, metadataReaderFactory) -> true;
        provider.addIncludeFilter(includeFilter);

        // 扫描有ScanAnnotation注解的类
        provider.addIncludeFilter(new AnnotationTypeFilter(ScanAnnotation.class));

        // 扫描ScanClassInterface接口的实现类,(接口不会被扫描出来,原因同上)
        provider.addIncludeFilter(new AssignableTypeFilter(ScanClassInterface.class));

        // 指定扫描的包名
        Set<BeanDefinition> candidateComponents = provider.findCandidateComponents("com.swt.javaBasic");
        candidateComponents.forEach(beanDefinition -> {
            getClassInfo((GenericBeanDefinition) beanDefinition);
            System.out.println("扫描到如下类：");
            System.out.println(beanDefinition.getBeanClassName());
        });
    }

    /**
     * 通过反射获取类和类注解中关联的类对象
     * @param beanDefinition
     */
    private static void getClassInfo(GenericBeanDefinition beanDefinition) {
        try {
            String beanClazzName = beanDefinition.getBeanClassName();
            Class<?> aClass = Class.forName(beanClazzName);
            ScanAnnotation annotation = aClass.getAnnotation(ScanAnnotation.class);
            if (!ObjectUtils.isEmpty(annotation)) {
                String priTypeName = annotation.value();
                Class<?> aClass1 = Class.forName(priTypeName);
                System.out.println(aClass + "-annotationClass:" + priTypeName);
                System.out.println(aClass1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
