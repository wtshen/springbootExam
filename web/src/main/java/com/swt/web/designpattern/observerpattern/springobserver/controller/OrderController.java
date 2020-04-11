package com.swt.web.designpattern.observerpattern.springobserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.swt.web.designpattern.observerpattern.springobserver.OrderMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:55 PM 2020/4/8.
 * @Modified By:
 */
@RestController
public class OrderController {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/notify")
    public void orderNotify() {
        JSONObject object = new JSONObject();
        object.put("id", 1);
        object.put("name", "香炉");

        OrderMessageEvent orderMessageEvent = new OrderMessageEvent(this);
        orderMessageEvent.setJsonObject(object);
        applicationContext.publishEvent(orderMessageEvent);
    }
}
