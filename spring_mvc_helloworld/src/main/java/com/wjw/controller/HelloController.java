package com.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author wjwdive
 * @Date 2022/8/15 22:35
 * @Description:
 */
//用注解声明此类为一个SpringMVC中控制层组件
@Controller
public class HelloController {
/**
 * / 在服务器中，斜线被解析为档期服务器的上下文路径  localhost:8080/
 *
 */
    @RequestMapping("/")
    public String protal() {
        //将逻辑视图返回, 在视图解析器中，会被处理成物理视图，WEB-INF/templates/index.html
        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
