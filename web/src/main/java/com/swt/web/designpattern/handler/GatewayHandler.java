package com.swt.web.designpattern.handler;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:10 PM 2020/3/27.
 * @Modified By:
 */
public abstract class GatewayHandler {
    private GatewayHandler gatewayHandler;

    protected abstract void service();

    protected void nextService() {
        if (this.gatewayHandler != null) {
            this.gatewayHandler.service();
        }
    }

    public void setNextGatewayHandler(GatewayHandler gatewayHandler) {
        this.gatewayHandler = gatewayHandler;
    }
}
