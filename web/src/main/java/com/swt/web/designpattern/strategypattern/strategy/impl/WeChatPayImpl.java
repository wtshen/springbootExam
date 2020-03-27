package com.swt.web.designpattern.strategypattern.strategy.impl;

import com.swt.web.designpattern.strategypattern.strategy.PayService;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:46 PM 2020/3/26.
 * @Modified By:
 */
public class WeChatPayImpl implements PayService {
    @Override
    public String pay() {
        return "wechatPay";
    }
}
