package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//测试之前需要执行的，共有的东西写在这个类里面
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite 运行了");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite 运行了");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest 运行了");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest 运行了");
    }
}
