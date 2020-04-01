package com.swt.web.designpattern.decoratepattern.gatewaydecorate.impl;

import com.swt.web.designpattern.decoratepattern.gatewaydecorate.AbstractDecorator;
import com.swt.web.designpattern.decoratepattern.gatewaydecorate.AbstractGatewayComponent;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:23 PM 2020/4/1.
 * @Modified By:
 */
public class LogDecorator extends AbstractDecorator{
    public LogDecorator(AbstractGatewayComponent abstractGatewayComponent) {
        super(abstractGatewayComponent);
    }

    @Override
    public void service() {
        //super.getAbstractGatewayComponent().service();
        super.service();
        System.out.println("step 2");
    }
}
