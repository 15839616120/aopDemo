package com.fangtianxia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot 项目搭建启动测试类
 * @author wyz
 */
@RequestMapping("system")
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

}
