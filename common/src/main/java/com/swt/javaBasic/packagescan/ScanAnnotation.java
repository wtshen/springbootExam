package com.swt.javaBasic.packagescan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 17:00 2020/1/17
 * @Modified By:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScanAnnotation {
    /**
     * SQLServer Dal Pojo Class Full Name
     */
    String value() default "";
}
