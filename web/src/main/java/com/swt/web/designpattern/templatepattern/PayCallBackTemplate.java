package com.swt.web.designpattern.templatepattern;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:20 PM 2020/3/31.
 * @Modified By:
 */
@Slf4j
public abstract class PayCallBackTemplate {
    Map<String, String> requestMap = new HashMap<>(3);

    public String payCallBack() {
        // 1. 验证参数和验证签名
        Map<String, String> requestMap = parseRequest();
        // 2. 记录日志
        payLog(requestMap);
        // 3. DB操作
        return service(requestMap);
    }

    protected abstract String service(Map<String, String> requestMap);

    private void payLog(Map<String, String> requestMap) {
        log.info("2. payLog..." + requestMap);
    }

    protected abstract Map<String, String> parseRequest();

    protected String resultFail() {
        return "fail";
    }

    protected String resultSuccess() {
        return "success";
    }
}
