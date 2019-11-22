package com.fangtianxia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wyz
 * 编写使用方法规则被拦截类
 */
@RestController
@RequestMapping("aop")
public class DemoMethodController {

    @RequestMapping("aopMethod")
    public String aopMethod(String aa){
        System.out.println("执行方法逻辑");
        return "返回值";
    }
}
