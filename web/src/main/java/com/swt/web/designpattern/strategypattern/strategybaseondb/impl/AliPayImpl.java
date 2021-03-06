package com.swt.web.designpattern.strategypattern.strategybaseondb.impl;

import com.swt.web.designpattern.strategypattern.strategybaseondb.PayService;
import org.springframework.stereotype.Service;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:46 PM 2020/3/26.
 * @Modified By:
 */
@Service("alipay")
public class AliPayImpl implements PayService {
    @Override
    public String pay() {
        return "alipay";
    }
}
