package com.swt.web.designpattern.handlerpattern.loghandler.impl;

import com.swt.web.designpattern.handlerpattern.loghandler.AbstractLogger;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 12:54 PM 2020/3/29.
 * @Modified By:
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("2.this is FileLogger..." + message);
    }
}
