package com.swt.web.designpattern.handler.service;

import com.swt.web.designpattern.SpringUtils;
import com.swt.web.designpattern.handler.GatewayHandler;
import com.swt.web.designpattern.handler.mapper.GatewayHandlerEntity;
import com.swt.web.designpattern.handler.mapper.GatewayHandlerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 2:22 PM 2020/3/28.
 * @Modified By:
 */
@Component
public class HandlerService {
    @Autowired
    GatewayHandlerMapper gatewayHandlerMapper;

    public GatewayHandler getFristGatewayHandler() {
        GatewayHandlerEntity firstGatewayHandler = gatewayHandlerMapper.getFirstGatewayHandler();
        String firstBeanId = firstGatewayHandler.getHandlerId();
        GatewayHandler firstBean = SpringUtils.getBean(firstBeanId, GatewayHandler.class);
        // 使用while循环 递归实现下一个节点关联
        String nextBeanId = firstGatewayHandler.getNextHandlerId();
        GatewayHandler tempNextBean = firstBean;

        while (!StringUtils.isEmpty(nextBeanId)) {
            // 从springboot容器中获取下一下handler对象
            GatewayHandler nextBean = SpringUtils.getBean(nextBeanId, GatewayHandler.class);
            GatewayHandlerEntity nextGatewayHandler = gatewayHandlerMapper.getNextGatewayHandler(nextBeanId);
            if (nextGatewayHandler == null) {
                break;
            }
            nextBeanId = nextGatewayHandler.getNextHandlerId();
            // 关联下一个handler对象
            tempNextBean.setNext(nextBean);
            tempNextBean = nextBean;
        }
        return firstBean;
    }
}
