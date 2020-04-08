package com.swt.web.designpattern.observerpattern.jdkobserver;

import com.swt.web.designpattern.observerpattern.jdkobserver.observer.SmsObserver;
import com.swt.web.designpattern.observerpattern.jdkobserver.observer.WeChatObserver;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:23 PM 2020/4/8.
 * @Modified By:
 */
public class Test {
    public static void main(String[] args){
        MessageObservable subject = new MessageObservable();
        subject.addObserver(new SmsObserver());
        subject.addObserver(new WeChatObserver());
        subject.notifyObservers("订阅成功");
    }
}
