package com.swt.web.designpattern.handlerpattern.loghandler;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 12:54 PM 2020/3/29.
 * @Modified By:
 */
public abstract class AbstractLogger {
    protected AbstractLogger nextLogger;

    protected int level;

    abstract public void write(String message);

    public void setNextLogger(AbstractLogger nextLogger) {
        if (nextLogger != null) {
            this.nextLogger = nextLogger;
        }
    }

    public void setNextWrite(int logLevel, String message) {
        if (this.level <= logLevel) {
            this.write(message);
        }
        if (this.nextLogger != null) {
            this.nextLogger.setNextWrite(logLevel, message);
        }
    }
}
