package com.swt.web.designpattern.decoratepattern.gatewaydecorate.impl;

import com.swt.web.designpattern.decoratepattern.gatewaydecorate.AbstractGatewayComponent;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:22 PM 2020/4/1.
 * @Modified By:
 */
public class BasicComponentGateway extends AbstractGatewayComponent {
    @Override
    public void service() {
        System.out.println("step 1");
    }
}
