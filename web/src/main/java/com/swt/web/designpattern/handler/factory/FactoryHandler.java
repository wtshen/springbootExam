package com.swt.web.designpattern.handler.factory;

import com.swt.web.designpattern.handler.impl.BlackListHandler;
import com.swt.web.designpattern.handler.impl.ConversationHandler;
import com.swt.web.designpattern.handler.impl.CurrentLimitHandler;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 11:20 PM 2020/3/27.
 * @Modified By:
 */
public class FactoryHandler {
    public static CurrentLimitHandler getFirstGatewayHandler(){
        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler();
        BlackListHandler blackListHandler = new BlackListHandler();
        ConversationHandler conversationHandler = new ConversationHandler();

        currentLimitHandler.setNextGatewayHandler(blackListHandler);
        blackListHandler.setNextGatewayHandler(conversationHandler);
        return currentLimitHandler;
    }
}
