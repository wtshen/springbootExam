package com.swt.web.designpattern.handlerpattern.handler.mapper;

import lombok.Data;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 2:16 PM 2020/3/28.
 * @Modified By:
 */
@Data
public class GatewayHandlerEntity {
    private Integer id;
    private String handlerName;
    private String handlerId;
    private String prevHandlerId;
    private String nextHandlerId;
}
