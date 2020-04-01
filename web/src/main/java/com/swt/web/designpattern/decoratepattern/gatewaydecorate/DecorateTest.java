package com.swt.web.designpattern.decoratepattern.gatewaydecorate;

import com.swt.web.designpattern.decoratepattern.gatewaydecorate.factory.DecorateFactory;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:36 PM 2020/4/1.
 * @Modified By:
 */
public class DecorateTest {
    public static void main(String[] args){
        AbstractGatewayComponent component = DecorateFactory.getComponent();
        component.service();
    }
}
