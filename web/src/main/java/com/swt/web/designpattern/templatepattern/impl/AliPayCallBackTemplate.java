package com.swt.web.designpattern.templatepattern.impl;

import com.mysql.cj.log.Log;
import com.swt.web.designpattern.templatepattern.PayCallBackTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:31 PM 2020/3/31.
 * @Modified By:
 */
@Slf4j
@Component
public class AliPayCallBackTemplate extends PayCallBackTemplate {
    @Override
    protected String service(Map<String, String> requestMap) {
        log.info("3. service");
        if (requestMap.get("status").equalsIgnoreCase("ok")) {
            return resultSuccess();
        } else {
            return resultFail();
        }
    }

    @Override
    protected Map<String, String> parseRequest() {
        log.info("1. parseRequest");
        Map<String, String> requestMap = new HashMap<>(4);
        requestMap.put("id", "1");
        requestMap.put("name", "阿里支付");
        requestMap.put("status", "ok");
        requestMap.put("code", "200");
        return requestMap;
    }
}
