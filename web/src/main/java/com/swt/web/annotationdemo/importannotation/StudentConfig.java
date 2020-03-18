package com.swt.web.annotationdemo.importannotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 4:32 PM 2020/3/15.
 * @Modified By:
 */
@Configuration
@Import(value = {Student.class, GoodStudent.class})
public class StudentConfig {
}
