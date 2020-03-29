package com.swt.web.designpattern.handlerpattern.loghandler.impl;

import com.swt.web.designpattern.handlerpattern.loghandler.AbstractLogger;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 12:54 PM 2020/3/29.
 * @Modified By:
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int levle) {
        this.level = levle;
    }
    @Override
    public void write(String message) {
        System.out.println("3.this is ErrorLogger..." + message);
    }
}