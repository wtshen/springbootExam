package com.swt.web.designpattern.strategy.context;

import com.swt.web.designpattern.strategy.PayService;
import com.swt.web.designpattern.strategy.factory.PayFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:55 PM 2020/3/26.
 * @Modified By:
 */
@Service
public class PayContext {
    @Autowired
    PayFactory payFactory;

    public String pay(String payCode) {
        PayService payService = payFactory.getPayService(payCode);
        if (Objects.isNull(payService)) {
            return "pay service not found.";
        }
        return payService.pay();
    }
}
