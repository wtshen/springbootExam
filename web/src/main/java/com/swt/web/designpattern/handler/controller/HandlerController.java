package com.swt.web.designpattern.handler.controller;

import com.swt.web.designpattern.handler.GatewayHandler;
import com.swt.web.designpattern.handler.factory.FactoryHandler;
import com.swt.web.designpattern.handler.impl.CurrentLimitHandler;
import com.swt.web.designpattern.handler.service.HandlerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    FactoryHandler factoryHandler;

    @Autowired
    HandlerService handlerService;

    @RequestMapping("/handler")
    public String handler(){
        CurrentLimitHandler firstGatewayHandler = factoryHandler.getFirstGatewayHandler();
        firstGatewayHandler.service();
        return "success";
    }


    @RequestMapping("/dbhandler")
    public String dbHandler(){
        GatewayHandler fristGatewayHandler = handlerService.getFristGatewayHandler();
        fristGatewayHandler.service();
        return "success";
    }
}
