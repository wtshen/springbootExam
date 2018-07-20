package com.swt.web.controller;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 16:09 2018/7/20
 * @Modified By:
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/index")
    public String freemarker(){
        return "index";
    }
}
