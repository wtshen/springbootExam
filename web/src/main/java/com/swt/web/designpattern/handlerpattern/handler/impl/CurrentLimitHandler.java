package com.swt.web.designpattern.handlerpattern.handler.impl;

import com.swt.web.designpattern.handlerpattern.handler.GatewayHandler;
import org.springframework.stereotype.Component;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:13 PM 2020/3/27.
 * @Modified By:
 */
@Component
public class CurrentLimitHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("限流----");
        this.nextService();
    }
}
