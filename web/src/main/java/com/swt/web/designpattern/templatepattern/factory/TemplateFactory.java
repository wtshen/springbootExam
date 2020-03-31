package com.swt.web.designpattern.templatepattern.factory;

import com.swt.web.designpattern.SpringUtils;
import com.swt.web.designpattern.templatepattern.PayCallBackTemplate;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:40 PM 2020/3/31.
 * @Modified By:
 */
public class TemplateFactory {
    public static PayCallBackTemplate getTemplate(String beanName) {
        return SpringUtils.getBean(beanName, PayCallBackTemplate.class);
    }
}
