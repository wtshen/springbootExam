package com.swt.web.controller;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 16:09 2018/7/20
 * @Modified By:
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @Value("${my.name}")
    private String myName;

    @RequestMapping("/index")
    public String freemarker() {
        return "index";
    }

    @RequestMapping("/printmyname")
    @ResponseBody
    public String printMyName(){
        return myName;
    }
}
