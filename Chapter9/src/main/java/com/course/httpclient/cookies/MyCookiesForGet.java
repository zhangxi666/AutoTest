/*
    获取cookies

 */
package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    //变量url
    private String url;
    //对象bundle
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件application中拼接测试url
        String uri = bundle.getString("testGetCookies.uri");
        String testUrl =this.url+uri;
        System.out.println(testUrl);
        //测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        // client 用来执行get方法
        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(get);
        //response.getEntity() 获取响应的所有内容
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        //遍历cookie key和value
        for (Cookie cookie: cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name + ";"+ "cookie value = "+ value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String result;
        String uri = bundle.getString("testGetWithCookies.uri");
        String testUrl =this.url+uri;
        //System.out.println(testUrl);
        //声明一个客户端
        HttpGet get = new HttpGet(testUrl);
        //声明一个执行方法
        DefaultHttpClient client = new DefaultHttpClient();
        //result = EntityUtils.toString(response.getEntity(),"utf-8");
        //System.out.println(result);
        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        //或i去响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("响应状态码 = " + statusCode);
        if (statusCode == 200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }

}
