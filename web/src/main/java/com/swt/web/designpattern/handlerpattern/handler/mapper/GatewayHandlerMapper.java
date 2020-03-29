package com.swt.web.designpattern.handlerpattern.handler.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 2:15 PM 2020/3/28.
 * @Modified By:
 */
public interface GatewayHandlerMapper {

    @Select("select handler_name as handlerName,handler_id as handlerId,prev_handler_id as prevHandlerId,next_handler_id as nextHandlerId from getway_handler where prev_handler_id is null")
    GatewayHandlerEntity getFirstGatewayHandler();

    @Select("select handler_name as handlerName,handler_id as handlerId,prev_handler_id as prevHandlerId,next_handler_id as nextHandlerId from getway_handler where handler_id=#{beanId}")
    GatewayHandlerEntity getNextGatewayHandler(String beanId);
}
