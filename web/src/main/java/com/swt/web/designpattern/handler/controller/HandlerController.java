package com.swt.web.designpattern.handler.controller;

import com.swt.web.designpattern.handler.factory.FactoryHandler;
import com.swt.web.designpattern.handler.impl.CurrentLimitHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:23 PM 2020/3/27.
 * @Modified By:
 */
@RestController
public class HandlerController {
    @RequestMapping("/handler")
    public String handler(){
        CurrentLimitHandler firstGatewayHandler = FactoryHandler.getFirstGatewayHandler();
        firstGatewayHandler.service();
        return "success";
    }
}
