package com.swt.web.designpattern.observerpattern.jdkobserver.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:23 PM 2020/4/8.
 * @Modified By:
 */
public class WeChatObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("发送微信通知,内容为:" + arg);
    }
}
