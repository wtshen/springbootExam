package com.swt.web.designpattern.strategybaseondb.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:39 PM 2020/3/26.
 * @Modified By:
 */
public interface PayTypeMapper {
    @Select("select id as id,type_name as typeName,type_id as type_Id,bean_id as beanId from pay_type where type_id=#{payCode}")
    PayTypeEntity getPayType(String payCode);
}
