package com.swt.web.designpattern.handler.impl;

import com.swt.web.designpattern.handler.GatewayHandler;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:13 PM 2020/3/27.
 * @Modified By:
 */
public class ConversationHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("会话拦截----");
        this.nextService();
    }
}
