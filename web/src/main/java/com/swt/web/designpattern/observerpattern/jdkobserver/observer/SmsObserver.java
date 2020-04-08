package com.swt.web.designpattern.observerpattern.jdkobserver.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:21 PM 2020/4/8.
 * @Modified By:
 */
public class SmsObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("发送短信通知,内容:" + arg);
    }
}
