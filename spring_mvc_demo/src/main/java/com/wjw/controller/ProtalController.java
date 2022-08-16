package com.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author wjwdive
 * @Date 2022/8/16 0:54
 * @Description:
 */

/**
 * 首页入口控制器
 */

@Controller
public class ProtalController {
    @RequestMapping("/")
    public String protal() {
        return "index";
    }
}
