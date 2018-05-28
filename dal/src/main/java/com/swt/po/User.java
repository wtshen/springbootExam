package com.swt.po;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 15:41 2018/3/2
 * @Modified By:
 */
@Component
@EqualsAndHashCode
@ToString
public class User {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String surname;

    @Setter
    @Getter
    private int age;

}