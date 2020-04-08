package com.swt.web.designpattern.observerpattern.jdkobserver;

import java.util.Observable;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:19 PM 2020/4/8.
 * @Modified By:
 */
public class MessageObservable extends Observable {
    @Override
    public void notifyObservers(Object arg) {
        // 修改状态为可以群发
        setChanged();
        // 群发通知
        super.notifyObservers(arg);
    }
}
