package com.swt.web.designpattern.handlerpattern.handler;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:10 PM 2020/3/27.
 * @Modified By:
 */
public abstract class GatewayHandler {
    private GatewayHandler gatewayHandler;

    public abstract void service();

    protected void nextService() {
        if (this.gatewayHandler != null) {
            this.gatewayHandler.service();
        }
    }

    public void setNext(GatewayHandler gatewayHandler) {
        this.gatewayHandler = gatewayHandler;
    }
}
