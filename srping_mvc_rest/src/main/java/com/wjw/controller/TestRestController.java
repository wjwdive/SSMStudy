package com.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wjwdive
 * @Date 2022/8/21 22:38
 * @Description:
 *
 * 查询所有的用户信息 --> /user  -->get
 * 根据id查询用户信息 --> /user/1  -->get
 * 添加用户信息 --> /user/1/admin  -->post  ..数据较多的时候依然可以通过表单提交的方式
 * 修改用户信息 --> /user  -->put
 * 删除用户信息 --> /user/1  -->delete
 *
 * 浏览器目前只能发送get,post请求，
 * 若要发送put和delete请求，需要在web.xml中配置一个HiddenHttpMethodFilter
 * 配置了过滤器之后，发送的请求满足两个条件，才能将请求转换为put，delete
 * 1、当前请求必须为post
 * 2、请求中必须有一个参数method="_method", value="put"
 */
@Controller
public class TestRestController {
//    @GetMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有的用户信息 --> /user -->get");
        return "success";
    }
//    @GetMapping("/user/{id}")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息 --> /user/" + id + " -->get");
        return "success";
    }
//  @PostMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加用户信息 --> /user -->post");
        return "success";
    }
//  @PutMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息 --> /user -->put");
        return "success";
    }
//    @DeleteMapping("/user/{id}")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除用户信息 --> /user -->delete, id: "+ id);
        return "success";
    }
}
