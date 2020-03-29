package com.swt.web.designpattern.handlerpattern.loghandler.service;

import com.swt.web.designpattern.handlerpattern.loghandler.AbstractLogger;
import com.swt.web.designpattern.handlerpattern.loghandler.impl.ConsoleLogger;
import com.swt.web.designpattern.handlerpattern.loghandler.impl.ErrorLogger;
import com.swt.web.designpattern.handlerpattern.loghandler.impl.FileLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 1:00 PM 2020/3/29.
 * @Modified By:
 */
@Service
public class LoggerService {
    @Autowired
    ConsoleLogger consoleLogger;
    @Autowired
    FileLogger fileLogger;
    @Autowired
    ErrorLogger errorLogger;

    public AbstractLogger getLoggerBean() {
        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(errorLogger);
        return consoleLogger;
    }
}
