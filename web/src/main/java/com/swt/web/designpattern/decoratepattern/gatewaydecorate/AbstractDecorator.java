package com.swt.web.designpattern.decoratepattern.gatewaydecorate;

import lombok.Data;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:23 PM 2020/4/1.
 * @Modified By:
 */
@Data
public abstract class AbstractDecorator extends AbstractGatewayComponent {
    AbstractGatewayComponent abstractGatewayComponent;

    public AbstractDecorator(AbstractGatewayComponent abstractGatewayComponent) {
        this.abstractGatewayComponent = abstractGatewayComponent;
    }

    @Override
    public void service() {
        if (this.abstractGatewayComponent != null) {
            this.abstractGatewayComponent.service();
        }
    }
}
