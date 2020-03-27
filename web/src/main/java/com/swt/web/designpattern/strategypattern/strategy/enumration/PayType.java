package com.swt.web.designpattern.strategypattern.strategy.enumration;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:48 PM 2020/3/26.
 * @Modified By:
 */
public enum PayType {
    ALIPAY("com.swt.web.designpattern.strategypattern.strategy.impl.AliPayImpl"),
    WECHATPAY("com.swt.web.designpattern.strategypattern.strategy.impl.WeChatPayImpl");

    String className;

    PayType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
