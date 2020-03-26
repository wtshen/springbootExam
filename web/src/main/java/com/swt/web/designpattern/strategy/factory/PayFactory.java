package com.swt.web.designpattern.strategy.factory;

import com.swt.web.designpattern.strategy.PayService;
import com.swt.web.designpattern.strategy.enumration.PayType;
import org.springframework.stereotype.Service;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:50 PM 2020/3/26.
 * @Modified By:
 */
@Service
public class PayFactory {
    public PayService getPayService(String payCode) {
        try {
            return (PayService) Class.forName(PayType.valueOf(payCode).getClassName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
