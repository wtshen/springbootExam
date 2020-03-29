package com.swt.web.designpattern.handlerpattern.handler.service;

import com.swt.web.designpattern.SpringUtils;
import com.swt.web.designpattern.handlerpattern.handler.GatewayHandler;
import com.swt.web.designpattern.handlerpattern.handler.mapper.GatewayHandlerEntity;
import com.swt.web.designpattern.handlerpattern.handler.mapper.GatewayHandlerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
    GatewayHandler gatewayHandler;

    public GatewayHandler getFristGatewayHandler() {
        // 将对象放到内存中避免每次都从DB加载，以此提高效率
        if (this.gatewayHandler != null) {
            return this.gatewayHandler;
        }
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
        this.gatewayHandler = firstBean;
        return firstBean;
    }
}
