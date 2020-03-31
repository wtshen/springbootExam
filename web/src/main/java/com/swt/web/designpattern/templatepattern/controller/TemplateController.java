package com.swt.web.designpattern.templatepattern.controller;

import com.swt.web.designpattern.templatepattern.PayCallBackTemplate;
import com.swt.web.designpattern.templatepattern.factory.TemplateFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:41 PM 2020/3/31.
 * @Modified By:
 */
@RestController
public class TemplateController {
    @RequestMapping("/callback")
    public String callBack(String type) {
        PayCallBackTemplate template = TemplateFactory.getTemplate(type);
        return template.payCallBack();
    }
}
