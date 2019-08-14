<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 注册对象的空间命名 -->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">
                <!-- 1.加载数据库驱动 -->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <!-- 2.数据库连接地址 -->
                <property name="url" value="jdbc:mysql:////192.168.2.170:3306/course"/>
                <!-- 3.数据库用户名  -->
                <property name="username" value="root"/>
                <!-- 4.数据库密码 -->
                <property name="password" value="admin"/>
            </dataSource>
        </environment>
    </environments>
    <!-- 注册映射文件：java对象与数据库之间的xml文件路径！ -->
    <mappers>
        <mapper resource="mapper/SQLMapper.xml"/>
    </mappers>

</configuration>