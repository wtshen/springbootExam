package com.swt.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wtshen
 * @Description: 日志记录注解
 * @Date: Created in 上午6:48 18/8/25.
 * @Modified By:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WriteLogAnnotation {
    String logTitle() default "";
}
