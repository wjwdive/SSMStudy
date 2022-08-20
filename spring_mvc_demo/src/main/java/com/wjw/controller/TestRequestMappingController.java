package com.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author wjwdive
 * @Date 2022/8/16 0:54
 * @Description:
 * 1、@RequestMapping 注解的位置及其作用
 * 类上的@RequestMapping， 设置映射请求的初始路径信息
 * 方法上的@RequestMapping，设置请求路径的具体信息
 *
 * 2、@RequestMapping注解的value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性时数组类型，即当浏览器所发送请求的请求路径匹配value属性中的任何一个值，当前请求都会被控制器或注解所表示的方法处理
 *
 * 3、@RequestMapping，注解的method属性  RequestMethod是个枚举属性
 *  作用：通过请求方式匹配请求
 *  method属性时RequestMethod类型的数组，即当前浏览器所发送请求的请求方式匹配method属性中的任何一个，请求都会被接收处理
 *  若当前请求的地址匹配value的值，但是方法匹配不到则页面会爆504，请求方法匹配不到
 * 派生注解：在value属性和method属性的结合下的派生的注解： @GetMapping，@PostMapping,@PutMappiong,@DeleteMapping
 *
 * 4、@RequestMapping注解的params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须瞒住params属性的设置：
 * “params”: 表示当请求映射所匹配请求的请求参数中必须携带params参数
 * “！params”:表示当前请求映射所匹配请求的请求参数中必须不携带params参数
 * “params = value”:表示当前请求映射所匹配请求的请求参数中必须携带params参数,且值为value
 * “params != value”:表示当前请求映射所匹配请求的请求参数中必须携带params参数,但是值不为value
 *
 * 5、@RequestMapping注解的headers属性
 *  和params属性类似，通过请求头信息匹配请求，即浏览器发送的请求的请求头信息必须瞒住headers属性的设置
 * "header"
 * "!header"
 * "header=value"
 * "header!=value"
 * 如果value属性匹配，但是headers属性不匹配，则404
 *
 * 6、Spring可以匹配ant风格的路径：
 * ?：表示单个任意字符。不包括?本身
 * *：表示任意个数的任意字符
 * **：表示任意层级的路径
 * 使用**时，只能使用  \/**\/xxx  \是转义字符
 *
 */
@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(
            value = {"/hello","/aaa","/index","/test/index"},//可以映射多个路径信息，是个数组，用大括号括起来。"aaa"， "a?a"，/**/aaa
            method = {RequestMethod.GET, RequestMethod.POST}
            //params = {"username", "!password","age=20"}//http://localhost:8080/SpringMVC/hello?username&age=20
//            headers = {}
    )
    public String hello(){
        return "index";
    }

    @RequestMapping({"/a?t"})
    public String  testAnt() {
        return "index";
    }

    @RequestMapping("/rest/{id}")
    public String testRest(@PathVariable("id") Integer id) {
        System.out.println("id:"+id);
        return "index";
    }

}
