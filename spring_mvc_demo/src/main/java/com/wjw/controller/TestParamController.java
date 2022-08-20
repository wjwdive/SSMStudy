package com.wjw.controller;

import com.wjw.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author wjwdive
 * @Date 2022/8/18 0:12
 * @Description:
 *
 * 获取请求参数的方式：
 * 1、通过servletAPI获取
 *  只需要在控制器方法的形参位置设置HttpServletRequest类型的形参
 *  就可以在控制器方法中使用request对象获取请求参数
 * 2、通过控制器方法的形参获取
 * 只需要在控制器的形参位置，设置形参，形参名字和请求参数的名字一致即可
 *
 * 3、@RequestParam : 将请求参数和控制器方法的形参绑定
 * @RequestParam 注解的三个属性：value,required,defaultValue
 * value：设置和形参绑定的请求参数的名字
 * required: 设置是否必须传输 value所对应的参数
 *  默认值为true,表示value所对应的请求参数必须传输，否则页面报错
 *  400，-Required String parameter 'xxx' is not present.
 * 若设置false,则表示value所对应的请求参数不是必须传输，则形参值为null,
 * defaultValue:设置当没有传输value所对应的请求参数时，为形参设置默认值，此时和required属性值无关
 *
 * 4、@RequestHeader:
 *
 * 5、@CookieValue:
 *
 * 6、通过控制器方法的实体类类型的形参获取请求参数
 * 要在控制器方法的形参位置设置实体类类型的形参，要保证实体类中属性的属性名和请求参数的名字一一对象
 * 可以通过实体类类型的形参获取请求参数
 */
@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) { //如果要用ServletRequestAPI,在这里直接加参数，除了request,还有response
        HttpSession session = request.getSession();//只要调用一次，就会保存浏览器的cookie
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ",password: " + password);
        return "index";
    }

    @RequestMapping("/param")
    public String getParamByParams(String username, String password) {
        System.out.println("username: " + username + ",password: " + password);
        return "index";
    }

    @RequestMapping("/paramCustom")
    public String getParamByParamsCustom(@RequestParam(value="userName", required = true, defaultValue = "admin") String username, String password ) {
        System.out.println("username: " + username + ",password: " + password);
        return "index";
    }


    @RequestMapping("/paramHeader")
    public String getParamByParamsHeader(@RequestParam(value="userName", required = true, defaultValue = "admin") String username,
                                         String password ,
                                         @RequestHeader("referer") String referer
    ) {
        System.out.println("referer: " + referer);
                System.out.println("username: " + username + ",password: " + password);
        return "index";
    }


    @RequestMapping("/paramSession")
    public String getParamByParamsSession(@RequestParam(value="userName", required = true, defaultValue = "admin") String username,
                                         String password ,
                                         @RequestHeader("referer") String referer,
                                         @CookieValue("JSESSIONID") String jssession
    ) {
        System.out.println("referer: " + referer);
        System.out.println("jssession: " + jssession);
        System.out.println("username: " + username + ",password: " + password);
        return "index";
    }

    @RequestMapping
    public String getParamByPojo(User user) { //属性名和参数名要一致
        System.out.println(user);
        return "index";
    }
}
