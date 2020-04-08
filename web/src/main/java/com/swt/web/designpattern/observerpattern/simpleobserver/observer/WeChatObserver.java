package com.swt.web.designpattern.observerpattern.simpleobserver.observer;

import com.swt.web.designpattern.observerpattern.simpleobserver.ObserverService;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:38 PM 2020/4/8.
 * @Modified By:
 */
public class WeChatObserver implements ObserverService {
    @Override
    public void update(String state) {
        System.out.println("发送微信通知:" + state);
    }
}
