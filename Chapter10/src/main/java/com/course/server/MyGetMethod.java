package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/myCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类,给客户端返回cookies信息
        Cookie cookie = new Cookie("login","ttt");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功!!!!!!!";
    }

    /*
    * 要求客户端携带cookies访问 怎么实现
    *
    * */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookiesarr = request.getCookies();
        if (Objects.isNull(cookiesarr)) {
            return "前端必须携带cookies信息来访问";
        }
        for (Cookie cookie : cookiesarr) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("ttt")) {
                String a=cookie.getName();
                String v=cookie.getValue();
                System.out.println("这是打印日志============="+ a+v);
                return "恭喜你访问成功";
            }
        }
        return "前端需要携带cookies信息来访问";
    }

    /*
    * 开发一个需要携带参数才能访问的get请求
    *
    * 第一种实现方式 url: key=value&key=value
    * 模拟获取商品列表
    * */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "开发一个需要携带参数才能访问的get请求,第一种实现方式",httpMethod = "GET")
    //前端访问：http://localhost:9999/get/with/param?start=10&end=20
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList1 = new HashMap<>();
        myList1.put("鞋",400);
        myList1.put("干脆面",1);
        myList1.put("衬衫",300);
        return myList1;
    }
    /*
    *第二种需要携带参数访问的get请求
    * url:ip:port/get/with/param/10/20
    * */

    @RequestMapping(value = "/get/with/param/{param1}/{param2}")
    @ApiOperation(value = "第二种需要携带参数访问的get请求",httpMethod = "GET")
    //http://localhost:9999/get/with/param/10/30
    public Map myGetList(@PathVariable Integer param1,
                         @PathVariable Integer param2){
        Map<String,Integer> myList2 = new HashMap<>();
        myList2.put("鞋",400);
        myList2.put("干脆面",1);
        myList2.put("衬衫",300);
        return myList2;
    }

}
