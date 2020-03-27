package com.swt.web.designpattern.strategybaseondb.mapper;

import lombok.Data;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:40 PM 2020/3/26.
 * @Modified By:
 */
@Data
public class PayTypeEntity {
    private Integer id;
    private String typeName;
    private String typeId;
    private String beanId;
}
