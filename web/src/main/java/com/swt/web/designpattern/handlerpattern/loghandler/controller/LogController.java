package com.swt.web.designpattern.handlerpattern.loghandler.controller;

import com.swt.web.designpattern.handlerpattern.loghandler.AbstractLogger;
import com.swt.web.designpattern.handlerpattern.loghandler.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:57 PM 2020/3/29.
 * @Modified By:
 */
@RestController(value = "mylogcontroller")
public class LogController {

    @Autowired
    LoggerService loggerService;

    @RequestMapping("/writelog")
    public String writeLog(int logLevel) {
        AbstractLogger loggerBean = loggerService.getLoggerBean();
        loggerBean.setNextWrite(logLevel, "this is a error");
        return "success";
    }
}
