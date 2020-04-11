package com.swt.web.designpattern.observerpattern.springobserver;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:47 PM 2020/4/8.
 * @Modified By:
 */
public class OrderMessageEvent extends ApplicationEvent {
    private JSONObject jsonObject;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderMessageEvent(Object source) {
        super(source);
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
