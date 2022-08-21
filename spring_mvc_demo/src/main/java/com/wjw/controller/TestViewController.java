package com.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author wjwdive
 * @Date 2022/8/21 10:18
 * @Description:
 */

@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleaf() {
        return "success";
    }

    //转发视图, 浏览器里地址栏不变
    @RequestMapping("/test/view/forward")
    public String testInternalResourceView() {
        return "forward:/test/model";
    }

    //转发视图，浏览器地址栏会变
    @RequestMapping("/test/view/redirect")
    public String testRedirectView() {
        return "redirect:/test/model";
    }


}
