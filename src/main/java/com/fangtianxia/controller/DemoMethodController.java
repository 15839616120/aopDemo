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
    public void aopMethod(){}
}