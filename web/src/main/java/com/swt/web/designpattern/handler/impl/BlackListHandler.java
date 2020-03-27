package com.swt.web.designpattern.handler.impl;

import com.swt.web.designpattern.handler.GatewayHandler;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:11 PM 2020/3/27.
 * @Modified By:
 */
public class BlackListHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("黑名单过滤---");
        this.nextService();
    }
}
