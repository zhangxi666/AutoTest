package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "/",description = "这是我的压测接口demo")
public class DemoAPI {

    @RequestMapping(value = "/getDemo/{userName}",method = RequestMethod.GET)
    @ApiOperation(value = "压测参数化接口测试",httpMethod = "GET")
    public String getDemo(@PathVariable String userName){
     //   String i ="aaa";
      //  userName=userName+i;
        return "你输入的内容是："+userName;
    }
}
