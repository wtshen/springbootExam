package com.swt.web.designpattern.strategybaseondb.context;

import com.swt.web.designpattern.strategybaseondb.PayService;
import com.swt.web.designpattern.strategybaseondb.SpringUtils;
import com.swt.web.designpattern.strategybaseondb.mapper.PayTypeEntity;
import com.swt.web.designpattern.strategybaseondb.mapper.PayTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:55 PM 2020/3/26.
 * @Modified By:
 */
@Service("PayContextBaseDB")
public class PayContext {
    @Autowired
    PayTypeMapper payTypeMapper;

    public String pay(String payCode) {

        PayTypeEntity payType = payTypeMapper.getPayType(payCode);

        PayService payService = SpringUtils.getBean(payType.getBeanId(), PayService.class);
        return payService.pay();
    }
}
