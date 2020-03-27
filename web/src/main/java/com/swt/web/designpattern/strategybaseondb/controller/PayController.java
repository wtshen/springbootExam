package com.swt.web.designpattern.strategybaseondb.controller;

import com.swt.web.designpattern.strategybaseondb.context.PayContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:58 PM 2020/3/26.
 * @Modified By:
 */
@RestController(value = "PayControllerBaseOnDB")
public class PayController {

    @Resource(name = "PayContextBaseDB")
    PayContext payContext;

    @RequestMapping("/paybaseondb")
    public String pay(String payCode) {
        return payContext.pay(payCode.toUpperCase());
    }
}
