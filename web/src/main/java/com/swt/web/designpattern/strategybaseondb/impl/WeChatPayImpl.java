package com.swt.web.designpattern.strategybaseondb.impl;

import com.swt.web.designpattern.strategybaseondb.PayService;
import org.springframework.stereotype.Service;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:46 PM 2020/3/26.
 * @Modified By:
 */
@Service("wechat")
public class WeChatPayImpl implements PayService {
    @Override
    public String pay() {
        return "wechatPay";
    }
}
