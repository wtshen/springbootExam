package com.swt.web.designpattern.strategy.impl;

import com.swt.web.designpattern.strategy.PayService;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:46 PM 2020/3/26.
 * @Modified By:
 */
public class AliPayImpl implements PayService {
    @Override
    public String pay() {
        return "alipay";
    }
}
