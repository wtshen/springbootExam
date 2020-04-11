package com.swt.web.designpattern.observerpattern.springobserver.listener;

import com.swt.web.designpattern.observerpattern.springobserver.OrderMessageEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:53 PM 2020/4/8.
 * @Modified By:
 */
@Component
public class WeChatListener implements ApplicationListener<OrderMessageEvent> {
    @Override
    @Async
    public void onApplicationEvent(OrderMessageEvent event) {
        System.out.println(Thread.currentThread().getName() + "发送微信通知,内容为:" + event.getJsonObject().toJSONString());
    }
}
