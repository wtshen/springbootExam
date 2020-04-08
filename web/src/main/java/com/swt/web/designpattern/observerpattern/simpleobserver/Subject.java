package com.swt.web.designpattern.observerpattern.simpleobserver;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:33 PM 2020/4/8.
 * @Modified By:
 */
public class Subject {
    List<ObserverService> observerServices = Lists.newArrayList();

    public void attch(ObserverService observer) {
        this.observerServices.add(observer);
    }

    public void detoch(ObserverService observer) {
        this.observerServices.remove(observer);
    }

    public void notifyObserver(String state) {
        for (ObserverService observerService : this.observerServices) {
            observerService.update(state);
        }
    }
}
