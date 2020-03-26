package com.swt.web.designpattern.strategy.controller;

import com.swt.web.designpattern.strategy.context.PayContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:58 PM 2020/3/26.
 * @Modified By:
 */
@RestController
public class PayController {

    @Autowired
    PayContext payContext;

    @RequestMapping("/pay")
    public String pay(String payCode) {
        return payContext.pay(payCode.toUpperCase());
    }
}
