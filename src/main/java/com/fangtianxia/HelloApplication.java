package com.fangtianxia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *两步：
 * 1.在当前类上添加@SpringBootApplication注解
 * 2.在主方法中指定当前类为引导类
 * @author wyz
 */
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        //在主方法中指定当前类为引导类
        SpringApplication.run(HelloApplication.class,args);
    }
}
