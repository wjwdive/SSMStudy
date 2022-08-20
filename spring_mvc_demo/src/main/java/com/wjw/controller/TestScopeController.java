package com.wjw.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author wjwdive
 * @Date 2022/8/18 1:32
 * @Description:
 *
 * 1、通过ModelAndView请求共享数据
 * 使用modelAndView时，可以使用其model功能向请求域共享数据
 * 使用view功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 * 2、使用model向请求域共享数据
 * 3、使用modelMap向请求域共享数据
 * 4、使用Map向请求域共享数据
 * 5、Model和modelMap和map的关系
 * 其实在底层中，这些类型的形参最终都是通过bindingAwareModelMap创建
 */
@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        /**
         * 包含model和view的功能
         * Model:向请求域中共享数据
         * View:设置逻辑视图实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域中共享数据
        mav.addObject("testRequestScope","Hello, ModelAndView");
        //设置逻辑视图
        mav.setViewName("success");
        return  mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope","hello, Model");
        return "success";
    }


    @RequestMapping("/test/modelMap")
    public String testmodelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope","hello, ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testmodelMap(Map<String, Object> map) {
        map.put("testRequestScope","hello, Map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope","hello, session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();// setAttribute("testRequestScope","hello, session");
        servletContext.setAttribute("testApplicationScope","hello application");
        return "success";
    }
}
