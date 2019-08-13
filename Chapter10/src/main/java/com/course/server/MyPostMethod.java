package com.course.server;


import com.course.bean.User;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    //这个变量是用来装cookies信息的
    private static Cookie cookie;
    //用户登陆成功获取到cookies
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登陆成功，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true) String userName,
                        @RequestParam(value = "password",required = true) String password){
        if (userName.equals("zhangsan") && password.equals("123456")){
            //加入cookie
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登陆成功了！！";
        }
        return "用户名或者密码错误！！！";


    }
    //再访问其他接口获取到列表
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody  User u){
        //获取cookies
        User user;
        //验证cookies是否合法
        Cookie[] cookies = request.getCookies();
        String name =u.getUserName();
        String pwd = u.getPassword();
        for(Cookie c : cookies){
            //不用 == 用equals判单
           if (c.getName().equals("login") && c.getValue().equals("true")
                   && "zhangsan".equals(name) && "123456".equals(pwd)
                   ){
                user = new User();
                user.setName("Lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
           }
        }
        return "cookie问题或equal出错，参数不合法"+name + pwd;
    }
}
