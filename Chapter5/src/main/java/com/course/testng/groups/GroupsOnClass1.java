package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {

    public void stu1(){
        System.out.println("GroupsOnClass1111 中的 stu1111 运行");
    }

    public void stu2(){
        System.out.println("GroupsOnClass1111 中的 stu2222 运行");
    }

}
