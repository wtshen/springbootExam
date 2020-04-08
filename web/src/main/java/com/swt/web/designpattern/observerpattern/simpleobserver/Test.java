package com.swt.web.designpattern.observerpattern.simpleobserver;

import com.swt.web.designpattern.observerpattern.simpleobserver.observer.SmsObserverImpl;
import com.swt.web.designpattern.observerpattern.simpleobserver.observer.WeChatObserver;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:39 PM 2020/4/8.
 * @Modified By:
 */
public class Test {
    public static void main(String[] args){
        Subject subject = new Subject();
        subject.attch(new SmsObserverImpl());
        subject.attch(new WeChatObserver());
        subject.notifyObserver("hello world");
    }
}
