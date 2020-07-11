package com.swt.collection;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午9:37 18/3/5.
 * @Modified By:
 */
public class UserInfo implements Serializable  {
    private Integer id;
    private double salary;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
