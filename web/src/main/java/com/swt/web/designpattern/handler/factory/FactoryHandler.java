package com.swt.web.designpattern.handler.factory;

import com.swt.web.designpattern.handler.impl.BlackListHandler;
import com.swt.web.designpattern.handler.impl.ConversationHandler;
import com.swt.web.designpattern.handler.impl.CurrentLimitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:20 PM 2020/3/27.
 * @Modified By:
 */
@Component
public class FactoryHandler {
    @Autowired
    CurrentLimitHandler currentLimitHandler;
    @Autowired
    BlackListHandler blackListHandler;
    @Autowired
    ConversationHandler conversationHandler;

    public CurrentLimitHandler getFirstGatewayHandler() {
        currentLimitHandler.setNext(blackListHandler);
        blackListHandler.setNext(conversationHandler);
        return currentLimitHandler;
    }
}
