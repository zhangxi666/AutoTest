package com.course.httpclient.demo;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        //用来存放我们的结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        //这个是用来执行get方法的
        HttpClient client = HttpClientBuilder.create().build();
        //execute返回HttpResponse,用response来存储
        HttpResponse response =  client.execute(get);
    //  response.getEntity()，返回httpEntity-就是获取响应的全部内容，用 EntityUtils.toString转换成字符串
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
