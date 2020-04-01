package com.swt.web.designpattern.decoratepattern.gatewaydecorate.factory;

import com.swt.web.designpattern.decoratepattern.gatewaydecorate.AbstractGatewayComponent;
import com.swt.web.designpattern.decoratepattern.gatewaydecorate.impl.BasicComponentGateway;
import com.swt.web.designpattern.decoratepattern.gatewaydecorate.impl.LimitDecorator;
import com.swt.web.designpattern.decoratepattern.gatewaydecorate.impl.LogDecorator;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:24 PM 2020/4/1.
 * @Modified By:
 */
public class DecorateFactory {
    public static AbstractGatewayComponent getComponent() {
        /*LogDecorator logDecorator = new LogDecorator();
        LimitDecorator limitDecorator = new LimitDecorator();
        limitDecorator.setAbstractGatewayComponent(logDecorator);
        logDecorator.setAbstractGatewayComponent(new BasicComponentGateway());
        return limitDecorator;*/

        return new LimitDecorator(new LogDecorator(new BasicComponentGateway()));
    }
}
