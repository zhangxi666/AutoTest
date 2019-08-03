package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("GroupsOnClass3中的 teacher1 运行");
    }

    public void teacher2(){
        System.out.println("GroupsOnClass3中的 teacher13 运行");
    }
}
