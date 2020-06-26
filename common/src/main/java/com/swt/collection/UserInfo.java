package com.swt.collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午9:37 18/3/5.
 * @Modified By:
 */
@Data
public class UserInfo implements Serializable {
    private Integer id;
    private double salary;
    private String name;
    private Integer age;
}
