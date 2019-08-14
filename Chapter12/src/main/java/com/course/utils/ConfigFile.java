package com.course.utils;
import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle =ResourceBundle.getBundle("application", Locale.CHINA);
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        //最终的测试地址
        String testUrl;
        //InterfaceName 为model中定义的枚举类，不可以传枚举之外的值
        if (name == InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");
        }
        if (name ==InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }
        if (name ==InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }
        if (name ==InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }

        if (name ==InterfaceName.ADDUSERINFO){
            uri = bundle.getString("addUserInfo.uri");
        }

        testUrl = address + uri;
        return testUrl;
    }
}
