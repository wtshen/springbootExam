package com.swt.model;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Created by wtshen on 18/2/17.
 */
@Entity
@Table(name="meminfo")
public class memInfo {
    @Id
    @GeneratedValue
    private Integer Id;
    private String name;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public memInfo() {
    }

    public memInfo(String name) {


        this.name = name;
    }
}
