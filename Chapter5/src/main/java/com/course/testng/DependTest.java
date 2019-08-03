package com.course.testng;

import org.testng.annotations.Test;
/**
 *  依赖测试:被依赖的test1执行通过，才会执行test2
 */

public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }


}
